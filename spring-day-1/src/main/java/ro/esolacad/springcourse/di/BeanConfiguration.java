package ro.esolacad.springcourse.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfiguration {

    @Bean
    public TaxCalculator taxCalculator(@Qualifier("getSecondName") String name) {
        System.out.println("------------------------------");
        System.out.println("CREATED FIRST TAX CALCULATOR");
        System.out.println("------------------------------");
        return new TaxCalculator(name);
    }

    @Bean
    public String getName() {
        return "INJECTED_NAME";
    }

    @Bean
    public String getSecondName() {
        return "SECOND_INJECTED_NAME";
    }

    @Bean("second")
    public TaxCalculator secondTaxCalculator() {
        System.out.println("------------------------------");
        System.out.println("CREATED SECOND TAX CALCULATOR");
        System.out.println("------------------------------");
        return new TaxCalculator("second");
    }

    @Bean
    @Scope("prototype")
    public TaxCalculator prototypeCalculator() {
        System.out.println("------------------------------");
        System.out.println("CREATED PROTOTYPE TAX CALCULATOR");
        System.out.println("------------------------------");
        return new TaxCalculator("prototype");
    }
}
