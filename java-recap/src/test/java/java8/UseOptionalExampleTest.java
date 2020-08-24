package java8;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import oop.Employee;

class UseOptionalExampleTest {

    @Test
    public void useGetEmployee() {

        Optional<Employee> employeeByIdOptional = UseOptionalExample.getEmployeeById(3L);

        employeeByIdOptional.ifPresent(employee -> System.out.println("There is an employee!"));

        employeeByIdOptional.orElseGet(() -> new Employee());

        if(employeeByIdOptional.isPresent()) {
            Employee employee = employeeByIdOptional.get();
        }
    }
}
