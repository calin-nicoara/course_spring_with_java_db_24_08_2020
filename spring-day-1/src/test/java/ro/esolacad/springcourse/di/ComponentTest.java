package ro.esolacad.springcourse.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;

@SpringBootTest
public class ComponentTest {

    @Autowired
    private FinanceComponent financeComponent;

    @Test
    public void testComponent() {
        financeComponent.doFinance();
    }
}
