package ro.esolacad.springcourse.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testSave() {
        Product product = new Product(null, "Orbit", BigDecimal.valueOf(2.5));

        Product product1 = productService.saveProduct(product);

        System.out.println(productRepository.findById(product1.getId()));
    }

    @Test
    public void findAllPage() {
        System.out.println( productService.findAll(0,2));
        System.out.println( productService.findAll(1,2));
        System.out.println( productService.findAll(2,2));
    }
}
