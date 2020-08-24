package stream;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import oop.Employee;

public class StreamTest {

    @Test
    public void noStream() {
        List<Employee> employeeList = Arrays.asList(
                new Employee(1L, "Dana Popescu", "manager", BigDecimal.valueOf(6000)),
                new Employee(2L, "Ionut Popescu", "manager", BigDecimal.valueOf(4000)),
                new Employee(3L, "Bogdan Popescu", "accountant", BigDecimal.valueOf(3500))
        );

        List<Employee> managerList = new ArrayList<>();

        for(Employee employee: employeeList) {
            if(employee.getTitle().equals("manager")) {
                employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(0.9)));
                managerList.add(employee);
            }
        }

        System.out.println(managerList);
    }

    @Test
    public void withStream() {
        List<Employee> employeeList = Arrays.asList(
                new Employee(1L, "Dana Popescu", "manager", BigDecimal.valueOf(6000)),
                new Employee(2L, "Ionut Popescu", "manager", BigDecimal.valueOf(4000)),
                new Employee(3L, "Bogdan Popescu", "accountant", BigDecimal.valueOf(3500))
        );

        List<Employee> manager1 = employeeList.stream()
                .filter(employee -> employee.getTitle().equals("manager"))
//                .map(manager -> {
//                    manager.setSalary(manager.getSalary().multiply(BigDecimal.valueOf(0.9)));
//                    return manager;
//                })
                .peek(manager -> manager.setSalary(manager.getSalary().multiply(BigDecimal.valueOf(0.9))))
                .filter(manager -> manager.getSalary().compareTo(BigDecimal.valueOf(2500)) > 1)
                .collect(Collectors.toList());
    }

    @Test
    public void testStream() {
        List<Integer> integers = Arrays.asList(20, 11, 25, 100, 200, 1000, 144, 177, 200);

        Supplier<Stream<String>> stringStreamSupplier = () -> integers.stream()
                .filter(x -> {
                    System.out.println("Filter: " + x);
                    return x % 2 == 0;
                })
                .peek(x -> System.out.println("Peek:" + x))
                .map(x -> Integer.toString(x));
//                .distinct()
//                .sorted()
//                .limit(3)
//                .skip(3)
//                .forEach(finalNumber -> System.out.println("Finished: " + finalNumber));

        stringStreamSupplier.get().forEach(finalNumber -> System.out.println("Finished: " + finalNumber));
        stringStreamSupplier.get().forEach(finalNumber -> System.out.println("Finished: " + finalNumber));
    }

    @Test
    public void testFlatMap() {
        List<Integer> integers1 = Arrays.asList(20, 11, 25, 100, 200, 1000, 144, 177, 200);
        List<Integer> integers2 = Arrays.asList(45, 234, 67, 23, 34, 64);

        List<List<Integer>> listOfLists = Arrays.asList(integers1, integers2);

        listOfLists
                .stream()
                .flatMap(list -> list.stream())
                .forEach(x -> System.out.println(x));
    }

    @Test
    public void testToMap() {
        List<Employee> employeeList = Arrays.asList(
                new Employee(1L, "Dana Popescu", "manager", BigDecimal.valueOf(6000)),
                new Employee(2L, "Ionut Popescu", "manager", BigDecimal.valueOf(4000)),
                new Employee(3L, "Bogdan Popescu", "accountant", BigDecimal.valueOf(5500)),
                new Employee(3L, "Diana Popescu", "accountant", BigDecimal.valueOf(6500))
        );

        Map<Long, BigDecimal> salariesMappedByEmployeeId = employeeList.stream()
                .filter(employee -> employee.getTitle().equals("manager"))
                .peek(manager -> manager.setSalary(manager.getSalary().multiply(BigDecimal.valueOf(0.9))))
                .filter(manager -> manager.getSalary().compareTo(BigDecimal.valueOf(2500)) > 0)
                .collect(Collectors.toMap(manager -> manager.getId(),
                        manager -> manager.getSalary()));
//                .collect(Collectors.toSet());

        System.out.println(salariesMappedByEmployeeId);
    }

    @Test
    public void testToGroupingBy() {
        List<Employee> employeeList = Arrays.asList(
                new Employee(1L, "Dana Popescu", "manager", BigDecimal.valueOf(6000)),
                new Employee(2L, "Ionut Popescu", "manager", BigDecimal.valueOf(4000)),
                new Employee(3L, "Bogdan Popescu", "accountant", BigDecimal.valueOf(5500)),
                new Employee(3L, "Diana Popescu", "accountant", BigDecimal.valueOf(6500))
        );

        Map<String, List<Employee>> employeesGroupedByTitle = employeeList.stream()
//                .filter(employee -> employee.getTitle().equals("manager"))
                .peek(manager -> manager.setSalary(manager.getSalary().multiply(BigDecimal.valueOf(0.9))))
                .filter(manager -> manager.getSalary().compareTo(BigDecimal.valueOf(2500)) > 0)
                .collect(Collectors.groupingBy(employee -> employee.getTitle()));
//                .collect(Collectors.toSet());

        System.out.println(employeesGroupedByTitle);
    }

    @Test
    public void testReduce() {
        List<Employee> employeeList = Arrays.asList(
                new Employee(1L, "Dana Popescu", "manager", BigDecimal.valueOf(6000)),
                new Employee(2L, "Ionut Popescu", "manager", BigDecimal.valueOf(4000)),
                new Employee(3L, "Bogdan Popescu", "manager", BigDecimal.valueOf(5500)),
                new Employee(3L, "Diana Popescu", "accountant", BigDecimal.valueOf(6500))
        );

        BigDecimal sumOfSalaries = employeeList.stream()
                .filter(employee -> employee.getTitle().equals("manager"))
                .map(manager -> manager.getSalary().multiply(BigDecimal.valueOf(0.9)))
                .reduce(BigDecimal.ZERO, (accumulator, currentValue) -> {
                    System.out.println("Acumulator:" + accumulator);
                    System.out.println("Current Value:" + currentValue);
                    return accumulator.add(currentValue);
                });

        System.out.println(sumOfSalaries);
    }

    @Test
    public void matchers() {
//        Arrays.stream()

        boolean anyMatch = Stream.of(1, 2, 3, 4, 11).anyMatch(x -> x > 10);
        System.out.println(anyMatch);

        boolean allMAtch = Stream.of(1, 3, 4, 5)
                .allMatch(x -> x % 2 != 0);
        System.out.println(allMAtch);

        boolean noneMatch = Stream.iterate(1, x -> x + 1)
                .limit(100)
                .noneMatch(x -> x > 100);

        System.out.println(noneMatch);

        Optional<Integer> any = Stream.of(1, 2, 3, 4, 5)
                .findFirst();
//                .findAny();

        System.out.println(any);
    }
}













