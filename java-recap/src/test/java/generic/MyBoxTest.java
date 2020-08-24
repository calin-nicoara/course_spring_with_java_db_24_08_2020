package generic;

import org.junit.jupiter.api.Test;

import oop.Employee;
import oop.ExecutiveEmployee;

public class MyBoxTest {

    @Test
    public void testNonGeneric() {
        MyBox myBox = new MyBox("Hello");

        System.out.println(myBox.getMyObject());
    }

    @Test
    public void tesGeneric() {
        MyBox<String> myBox = new MyBox<>("Hello");

        String myString = myBox.getMyObject();
        System.out.println(myString);
    }

    @Test
    public void testBoxEmployee() {
        MyBox<ExecutiveEmployee> executiveEmployeeMyBox = new MyBox<>(
                new ExecutiveEmployee());

        MyBox<? extends Employee> employeeMyBox = executiveEmployeeMyBox;
    }
}
