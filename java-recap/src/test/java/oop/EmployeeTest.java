package oop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class EmployeeTest {

    @Test
    public void testEmployee() {
        Employee employee = new Employee("Ionut Popescu", "manager",
                BigDecimal.valueOf(5000));

        employee.setTitle("Manager");

        assert employee.getTitle().equals("Manager");
    }
}
