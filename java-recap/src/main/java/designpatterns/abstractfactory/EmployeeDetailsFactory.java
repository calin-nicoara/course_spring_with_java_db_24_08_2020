package designpatterns.abstractfactory;


public interface EmployeeDetailsFactory {
    EmployeeHistory getEmployeeHistory();
    EmployeeReview getEmployeeReview();
}
