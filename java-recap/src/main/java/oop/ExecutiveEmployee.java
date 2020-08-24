package oop;

import java.math.BigDecimal;

public class ExecutiveEmployee extends Employee{

    private BigDecimal executiveBonus;

    public ExecutiveEmployee() {}

    public ExecutiveEmployee(String name, String title, BigDecimal salary,
                             BigDecimal executiveBonus) {
        super(name, title, salary);
        this.executiveBonus = executiveBonus;
    }

    public BigDecimal getExecutiveBonus() {
        return executiveBonus;
    }

    public void setExecutiveBonus(final BigDecimal executiveBonus) {
        this.executiveBonus = executiveBonus;
    }

    @Override
    public String getTitle() {
        return "Executive " + super.getTitle();
    }
}
