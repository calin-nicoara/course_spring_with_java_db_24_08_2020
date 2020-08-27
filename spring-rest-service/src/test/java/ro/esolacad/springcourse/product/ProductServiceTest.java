package ro.esolacad.springcourse.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void testFindById() {
        long id = 1L;

        ProductModel expectedProductModel = getProductModel(id);

        Product productfromRepo = getProduct(id);

        Mockito.when(productRepository.findById(id))
                .thenReturn(Optional.of(productfromRepo));

        Optional<ProductModel> result = productService.findById(id);

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(expectedProductModel, result.get());
    }

    @Test
    public void testFindByIdNoProduct() {
        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.empty());

        Optional<ProductModel> result = productService.findById(1L);

        Assertions.assertEquals(Optional.empty(), result);
    }

    @Test
    public void testSaveProduct() {
        ProductModel expectedProductModel = getProductModel(null);

        Product productForSaving = getProduct(null);

        productService.saveProduct(expectedProductModel);

        Mockito.verify(productRepository).save(productForSaving);

        Mockito.verifyNoMoreInteractions(productRepository);
    }

    private Product getProduct(final Long id) {
        return Product.builder()
                .id(id)
                .name("Coca-Cola")
                .status(ProductStatus.AVAILABLE)
                .price(BigDecimal.ONE)
                .build();
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
