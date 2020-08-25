package ro.esolacad.springcourse.di;

import java.math.BigDecimal;

public class TaxCalculator {

    private final String name;
    private Integer value;

    public TaxCalculator(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getTaxes(BigDecimal income) {
        return income.multiply(BigDecimal.valueOf(0.1));
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(final Integer value) {
        this.value = value;
    }
}
