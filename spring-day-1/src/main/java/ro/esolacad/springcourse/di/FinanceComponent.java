package ro.esolacad.springcourse.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

@Component
public class FinanceComponent {

    @PostConstruct
    public void init() {
        System.out.println("------------------");
        System.out.println("CREATED FinanceComponent");
        System.out.println("------------------");
    }

    private final TaxCalculatorComponent taxCalculatorComponent;
    private final FinanceFileWriter csvFileWriter;
    private BigDecimal randomValue;

//    @Autowired
    public FinanceComponent(final TaxCalculatorComponent taxCalculatorComponent,
                            final FinanceFileWriter financeFileWriter) {
        this.taxCalculatorComponent = taxCalculatorComponent;
        this.csvFileWriter = financeFileWriter;
    }

    public void doFinance() {
        BigDecimal taxes = taxCalculatorComponent.getTaxes(BigDecimal.valueOf(2000));
        csvFileWriter.writeFile(taxes.toString());
    }

    @Autowired(required = false)
    public void setRandomValue(final BigDecimal randomValue) {
        this.randomValue = randomValue;
    }
}
