package ro.esolacad.springcourse.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;

import java.util.List;

@SpringBootTest
public class JpaRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testFind() {
        List<Product> all = productRepository.findAll();

        System.out.println(all);
    }

    @Test
    public void testFindbyId() {
        System.out.println(productRepository.findById(-2L));
    }

    @Test
    public void testDelete() {
        productRepository.deleteById(-1L);

        System.out.println(productRepository.findAll());
    }

    @Test
    public void testMics() {
        System.out.println(productRepository.existsById(-1L));
        System.out.println(productRepository.count());
    }
}
