package lambdas;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import oop.Employee;

public class LambdaTEst {

    @Test
    public void firstLambda() {
        NumericTest numericTest = input -> input * 2;

        System.out.println(numericTest.transformNumber(10));

        JustOutput justOutput = () -> 200;

        System.out.println(justOutput.getNumber());

        JustInput justInput = System.out::println;
        justInput.consumeNumber(10000);

        MoreParamLabmda moreParamLabmda = (first, second) ->
                first + " " + second;

        System.out.println(moreParamLabmda.moreParams("Hello", 42));

        final String useForLambda = "For Lambda!";

        MoreParamLabmda moreParamLabmda2 = (first, second) -> {
            System.out.println(useForLambda);
            return first + " " + second;
        };

        System.out.println(moreParamLabmda2.moreParams("Hello again", 42));
    }

    @Test
    public void testJavaFunctionalInterfaces() {
        Consumer<String> simpleConsumer = parameter ->
                System.out.println("Consumed this:" + parameter);

        simpleConsumer.accept("consumed");

        Supplier<Employee> supplier = () -> {
            Employee employee = new Employee();
            employee.setName("NAME");
            return employee;
        };

        System.out.println(supplier.get());

        Function<Long, Employee> employeeWithIdMapper = id -> {
            Employee employee = new Employee();
            employee.setId(id);
            employee.setName("NAME");
            return employee;
        };

        System.out.println(employeeWithIdMapper.apply(2L));

        Predicate<Employee> salaryOver4000Predicate = employee ->
                employee.getSalary().compareTo(BigDecimal.valueOf(4000)) > 0;

        Employee employee = new Employee();
        employee.setSalary(BigDecimal.valueOf(5000));
        System.out.println(salaryOver4000Predicate.test(employee));

        employee.setSalary(BigDecimal.valueOf(3000));
        System.out.println(salaryOver4000Predicate.test(employee));
    }
}















