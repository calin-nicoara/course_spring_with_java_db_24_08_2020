package ro.esolacad.springcourse.di;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

@Component
public class TaxCalculatorComponent {

    @PostConstruct
    public void init() {
        System.out.println("------------------");
        System.out.println("CREATED TaxCalculatorComponent");
        System.out.println("------------------");
    }

    private final String name;

//    @Autowired
    public TaxCalculatorComponent(final @Qualifier("getName") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getTaxes(BigDecimal income) {
        return income.multiply(BigDecimal.valueOf(0.1));
    }
}
