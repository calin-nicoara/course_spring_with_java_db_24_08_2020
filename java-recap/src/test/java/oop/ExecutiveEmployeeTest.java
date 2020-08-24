package oop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ExecutiveEmployeeTest {

    @Test
    public void testExecutiveEmployee() {
        ExecutiveEmployee executiveEmployee = new ExecutiveEmployee();

        executiveEmployee.setTitle("HIGH EXECUTIVE");

        System.out.println(executiveEmployee.getTitle());

        executiveEmployee.setExecutiveBonus(BigDecimal.valueOf(100000));

        System.out.println(executiveEmployee.getExecutiveBonus());
    }

    @Test
    public void testOverride() {
        ExecutiveEmployee executiveEmployee = new ExecutiveEmployee();
        executiveEmployee.setTitle("Manager");

//        System.out.println(executiveEmployee.getTitle());

        Employee employee = executiveEmployee;

        System.out.println(employee.getTitle());
    }
}
