package ro.esolacad.springcourse.product;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;
import java.util.Arrays;

import ro.esolacad.springcourse.GenericListModel;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = ProductResource.class)
public class ProductResourceIntegrationTest {

    @MockBean
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private ProductModelValidator productModelValidator;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllProductsOld() throws Exception {
        GenericListModel<ProductModel> genericListModel = GenericListModel.<ProductModel>builder()
                .items(Arrays.asList(getProductModel(1L)))
                .totalPages(1)
                .totalElements(2)
                .build();

        Mockito.when(productService.findAllProductsOld(10, 0))
                .thenReturn(genericListModel);

        MvcResult mvcResult = mockMvc.perform(
                get("/api/product/old_version")
                .with(user("admin").password("admin").roles("API"))
        ).andExpect(status().isOk()).andReturn();


        String actualResult = mvcResult.getResponse().getContentAsString();

        String expectedResult = objectMapper.writeValueAsString(genericListModel);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    private ProductModel getProductModel(final Long id) {
        return ProductModel.builder()
                .id(id)
                .name("Coca-Cola")
                .status(ProductStatus.AVAILABLE)
                .price(BigDecimal.ONE)
                .build();
    }
}














