package ro.esolacad.springcourse.product;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;
import java.util.Optional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ProductComponentTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Sql("/test_sql/product.sql")
    @Sql(value = "/test_sql/delete.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testSaveProduct() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                post("/api/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(getProductModel(null)))
                        .with(user("admin").password("admin").roles("API", "WRITER"))
        ).
                andExpect(status().isOk())
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());

        Optional<Product> byId = productRepository.findById(1L);
        System.out.println(byId);
    }

    private ProductModel getProductModel(final Long id) {
        return ProductModel.builder()
                .id(id)
                .name("FROM_COMPONENT_TEST")
                .status(ProductStatus.AVAILABLE)
                .price(BigDecimal.ONE)
                .build();
    }
}
