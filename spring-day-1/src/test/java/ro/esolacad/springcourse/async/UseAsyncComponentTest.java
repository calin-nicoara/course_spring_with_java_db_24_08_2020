package ro.esolacad.springcourse.async;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UseAsyncComponentTest {

    @Autowired
    private UseAsyncComponent asyncComponent;

    @Test
    public void testAsync() throws InterruptedException {
        asyncComponent.doSomething();


        Thread.sleep(300);
    }
}
