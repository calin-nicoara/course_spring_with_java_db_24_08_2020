package ro.esolacad.springcourse.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;

@SpringBootTest
public class LazyTest {

    @Autowired
    private LazyComponent lazyComponent;

    @Test
    public void testLazy() {

    }
}
