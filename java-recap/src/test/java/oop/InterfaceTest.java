package oop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class InterfaceTest {

    @Test
    public void testInterfaces() {
        Employee employee = new Employee();
        employee.setSalary(BigDecimal.valueOf(4000));

        Payable payable = employee;

        payable.paySalary(BigDecimal.valueOf(2000));

        Taxable taxable = employee;

        System.out.println(taxable.getTaxes());
    }
}
