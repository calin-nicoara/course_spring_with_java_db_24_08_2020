package java8;

import java.util.Optional;

import oop.Employee;

public class UseOptionalExample {

    public static Optional<Employee> getEmployeeById(Long id) {
        if(id.equals(1L)) {
            return Optional.of(new Employee());
        } else {
            return Optional.empty();
        }
    }
}
