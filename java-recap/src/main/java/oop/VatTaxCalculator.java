package oop;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class VatTaxCalculator {

    private Map<String, BigDecimal> vatPercentages = new HashMap<>();

    public VatTaxCalculator() {
        vatPercentages.put("RO", BigDecimal.valueOf(0.19));
        vatPercentages.put("HU", BigDecimal.valueOf(0.24));
    }

    public BigDecimal getValueWithTax(BigDecimal valueWithoutTax, String countryCode) {
        BigDecimal percentage = vatPercentages.get(countryCode);

        return valueWithoutTax.add(valueWithoutTax.multiply(percentage));
    }

}
