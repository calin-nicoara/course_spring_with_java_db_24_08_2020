package oop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class VatTaxCalculatorTest {

    @Test
    public void testtaxes() {
        VatTaxCalculator vatTAxCalculator = new VatTaxCalculator();

        BigDecimal ro = vatTAxCalculator.getValueWithTax(BigDecimal.valueOf(10),
                "RO");

        System.out.println(ro);
    }
}
