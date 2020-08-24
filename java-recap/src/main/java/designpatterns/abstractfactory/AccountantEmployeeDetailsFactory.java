package designpatterns.abstractfactory;

public class AccountantEmployeeDetailsFactory implements EmployeeDetailsFactory {
    @Override
    public EmployeeHistory getEmployeeHistory() {
        return new AccoutantEmployeeHistory();
    }

    @Override
    public EmployeeReview getEmployeeReview() {
        return new AccountantEmployeeReview();
    }
}
