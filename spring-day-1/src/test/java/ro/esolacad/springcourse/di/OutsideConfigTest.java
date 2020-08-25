package ro.esolacad.springcourse.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OutsideConfigTest {

    @Autowired
    private BigDecimal bigDecimal;

    @Test
    public void testDecimal() {
        System.out.println(bigDecimal);
    }
}
