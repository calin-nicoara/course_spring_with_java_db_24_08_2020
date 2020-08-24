package designpatterns.abstractfactory;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

class AccountantEmployeeDetailsFactoryTest {

    @Test
    public void testUseFactory() {
        EmployeeDetailsFactory employeeDetailsFactory = new AccountantEmployeeDetailsFactory();

        EmployeeHistory employeeHistory = employeeDetailsFactory.getEmployeeHistory();
        System.out.println("History: " + employeeHistory.getYearsWorking());

        EmployeeReview employeeReview = employeeDetailsFactory.getEmployeeReview();
        System.out.println("Review: " + employeeReview.getScore());
    }

}
