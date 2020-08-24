package designpatterns.factorymethod;

public class ActionPlanEmployee implements ActionPlanPerson{

    private String name;

    public ActionPlanEmployee(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void doJob() {
        System.out.println("I am an employeed! I am doing my job");
    }

    public void getSalary(Integer salary) {
        System.out.println("Got my salary! " + salary);
    }
}
