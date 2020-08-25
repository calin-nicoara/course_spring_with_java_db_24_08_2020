package ro.esolacad.springcourse.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CustomMethodForRepoTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testPriceGreater() {
        List<Product> allByPriceGreaterThan = productRepository.findAllByPriceGreaterThanEqual(BigDecimal.valueOf(3.5));

        System.out.println(allByPriceGreaterThan);
    }

    @Test
    public void testNameLike() {
        List<Product> byNameLike = productRepository
                .findByNameLike("%Cola%");

        System.out.println(byNameLike);
    }

    @Test
    public void testPriceLessthan() {
        Optional<Product> byPriceLessThan = productRepository.findByPriceLessThan(BigDecimal.valueOf(2));

        System.out.println(byPriceLessThan);
    }
}
