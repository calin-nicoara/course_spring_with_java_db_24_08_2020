package ro.esolacad.springcourse.jpa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    public void testLombok() {
        Product product = new Product();

        product.setId(1L);

        Product product2 = new Product();
        product2.setId(1L);

        System.out.println(product.equals(product2));
    }

}
