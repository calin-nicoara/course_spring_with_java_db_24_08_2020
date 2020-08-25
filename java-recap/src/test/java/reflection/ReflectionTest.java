package reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import oop.Employee;
import oop.ExecutiveEmployee;

public class ReflectionTest {

    @Test
    public void testClassClass() {
        Object employee = new Employee();

//        Class<Employee> employeeClass = Employee.class;

        Class<?> employeeClass = employee.getClass();
        System.out.println(employeeClass.getName());
        System.out.println(employeeClass.getSimpleName());
    }

    @Test
    public void testContructor() {
        Class<?> employeeClass = Employee.class;

        Constructor<?>[] constructors = employeeClass.getConstructors();



        for(Constructor<?> constructor: constructors) {
            System.out.println(constructor.getParameterCount());
            System.out.println(Arrays.toString(constructor.getParameterTypes()));
        }
    }

    @Test
    public void testField() {
        ExecutiveEmployee executiveEmployee = new ExecutiveEmployee();
        executiveEmployee.setExecutiveBonus(BigDecimal.TEN);

        Class<?> employeeClass = ExecutiveEmployee.class;

        for(Field field:  employeeClass.getFields()) {
//            System.out.println(field.getName());
        }

//        System.out.println();
//        System.out.println();
//        System.out.println();
        for(Field field:  employeeClass.getDeclaredFields()) {
//            System.out.println(field.getName());
        }

        try {
            Field executiveBonusField = employeeClass.getDeclaredField("executiveBonus");

            executiveBonusField.setAccessible(true);
            Object o = executiveBonusField.get(executiveEmployee);

            System.out.println(o);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetMethod() {
        ExecutiveEmployee executiveEmployee = new ExecutiveEmployee();
        executiveEmployee.setExecutiveBonus(BigDecimal.TEN);

        Class<?> aClass = executiveEmployee.getClass();


        try {
            Method getExecutiveBonusMethod = aClass.getDeclaredMethod("getExecutiveBonus");

            Object result = getExecutiveBonusMethod.invoke(executiveEmployee);
            System.out.println(result);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSetMethod() {
        ExecutiveEmployee executiveEmployee = new ExecutiveEmployee();
        executiveEmployee.setExecutiveBonus(BigDecimal.TEN);

        Class<?> aClass = executiveEmployee.getClass();


        try {
            Method getExecutiveBonusMethod = aClass
                    .getDeclaredMethod("setExecutiveBonus", BigDecimal.class);

            getExecutiveBonusMethod.invoke(executiveEmployee, BigDecimal.ZERO);

            System.out.println(executiveEmployee.getExecutiveBonus());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindGetMethods() {
        Employee employee = new Employee();
        Class<?> employeeClass = employee.getClass();

        Arrays.stream(employeeClass.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("get"))
                .filter(method -> Modifier.isPublic(method.getModifiers()))
                .filter(method -> method.getParameterCount() == 0)
                .filter(method -> method.getReturnType() != Void.class)
                .forEach(method -> System.out.println(method.getName()));
    }

    @Test
    public void testProxy() {
        List<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        List proxyList = (List) Proxy.newProxyInstance(List.class.getClassLoader(),
                new Class[]{List.class},
                (proxy, method, args) -> {
                    System.out.println("Method that is called " + method.getName());
                    System.out.println("BEfore method is called");
                    Object invokeResult = method.invoke(numbers, args);
                    System.out.println("After method is called");

                    return invokeResult;
                });

        proxyList.add(6);

        System.out.println(proxyList.get(4));
    }
}
