package ro.esolacad.springcourse.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class ProductJdbcServiceTest {

    @Autowired
    private ProductJdbcService productJdbcService;

    @Test
    public void countProducts() {
        Integer integer = productJdbcService.countProducts();

        System.out.println(integer);
    }

    @Test
    public void getAllProducts() {
        System.out.println(productJdbcService.findAllProducts());
    }

    @Test
    public void testFindById() {
        ProductJdbc productById = productJdbcService.findProductById(-1L);

        System.out.println(productById);
    }

    @Test
    public void testInsertProduct() {
        ProductJdbc productJdbc = new ProductJdbc(1L,"Dero", BigDecimal.valueOf(20));

        productJdbcService.insertProduct(productJdbc);

        System.out.println(productJdbcService.findProductById(1L));
    }

    @Test
    public void testInsertProductNamed() {
        ProductJdbc productJdbc = new ProductJdbc(1L,"Dero", BigDecimal.valueOf(20));

        productJdbcService.insertProductWithNamed(productJdbc);

        System.out.println(productJdbcService.findProductById(1L));
    }

}
