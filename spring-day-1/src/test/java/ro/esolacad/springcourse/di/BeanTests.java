package ro.esolacad.springcourse.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

@SpringBootTest
public class BeanTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    @Qualifier("taxCalculator")
    private TaxCalculator calculator;

    @Test
    public void taxCalculatorNoSpring() {
        TaxCalculator taxCalculator = new TaxCalculator("nospring");

        System.out.println(taxCalculator.getName());
        System.out.println(taxCalculator.getTaxes(BigDecimal.TEN));
    }

    @Test
    public void taxCalculatorGetWithSpring() {
//        TaxCalculator taxCalculator = applicationContext.getBean(TaxCalculator.class);
//        TaxCalculator taxCalculator = (TaxCalculator) applicationContext.getBean("taxCalculator");
        TaxCalculator taxCalculator = applicationContext.getBean("taxCalculator", TaxCalculator.class);

        System.out.println(taxCalculator.getName());
        System.out.println(taxCalculator.getTaxes(BigDecimal.TEN));
    }

    @Test
    public void taxCalculatorGetSecondWithSpring() {
        TaxCalculator taxCalculator = applicationContext.getBean("second", TaxCalculator.class);

        System.out.println(taxCalculator.getName());
        System.out.println(taxCalculator.getTaxes(BigDecimal.TEN));
    }

    @Test
    public void taxCalculatorTestScope() {
        TaxCalculator taxCalculator = applicationContext.getBean(TaxCalculator.class);

        System.out.println(taxCalculator.getName());
        System.out.println();
        taxCalculator.setValue(20);

        TaxCalculator bean = applicationContext.getBean(TaxCalculator.class);

        System.out.println(bean.getName());
        System.out.println(bean.getValue());
    }

    @Test
    public void testPrototypeBean() {
        TaxCalculator taxCalculator = applicationContext.getBean("prototypeCalculator", TaxCalculator.class);

        System.out.println(taxCalculator.getName());
        taxCalculator.setValue(50);

        TaxCalculator secondTaxCalculator = applicationContext.getBean("prototypeCalculator", TaxCalculator.class);
        System.out.println(secondTaxCalculator.getName());
        System.out.println(secondTaxCalculator.getValue());
    }

    @Test
    public void testAutowired() {
        System.out.println(calculator.getName());
        System.out.println(calculator.getTaxes(BigDecimal.TEN));
    }
}
