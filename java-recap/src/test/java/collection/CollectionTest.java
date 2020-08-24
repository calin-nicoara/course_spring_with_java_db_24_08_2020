package collection;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

import oop.Employee;

public class CollectionTest {

    @Test
    public void testArray() {
        int[] arrayInts = new int[] {1, 2, 3, 4, 5, 6};

        System.out.println(arrayInts[0]);

        System.out.println(Arrays.toString(arrayInts));
    }

    @Test
    public void testList() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(4);

        System.out.println(integers);

        System.out.println(integers.get(3));

        integers.contains(4);
    }

    @Test
    public void testSet() {
        Set<Integer> integers = new HashSet<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(4);

        System.out.println(integers);

        integers.contains(4);
    }

    @Test
    public void testSetWithObject() {
        Employee employee1 = new Employee();
        employee1.setName("Ionut");

        Employee employee2 = new Employee();
        employee2.setName("Ana");

        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(employee1);
        employeeSet.add(employee2);

//        System.out.println(employeeSet);

//        Employee employee3 = new Employee();
//        employee3.setName("Ionut");

//        employeeSet.add(employee3);

        System.out.println(employeeSet);

        employee1.setName("Ionut 2");
        employeeSet.add(employee1);

        System.out.println(employeeSet);
    }

    @Test
    public void boxed() {
        Integer integer = 10;

        int newvalue = 10 + integer;
    }

    @Test
    public void testHashMap() {
        Employee employee1 = new Employee(1L, "Ionut Popescu", "manager",
                BigDecimal.valueOf(5000));
        Employee employee2 = new Employee(2L, "Dana Popescu", "manager",
                BigDecimal.valueOf(6000));

        Map<Long, Employee> employeeMap = new HashMap<>();


        employeeMap.put(employee2.getId(), employee2);
        employeeMap.put(employee1.getId(), employee1);

//        System.out.println(employeeMap);

//        System.out.println(employeeMap.get(employee1.getId()));

        employeeMap.put(1L, null);

//        System.out.println(employeeMap.get(employee1.getId()));

        employeeMap.put(null, new Employee());

        System.out.println(employeeMap.get(null));
    }

    @Test
    public void testUtils() {
        List<Object> objects = Collections.emptyList();
//        Collections
    }
}
