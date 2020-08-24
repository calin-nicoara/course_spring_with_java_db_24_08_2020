package designpatterns.factorymethod;

public abstract class MonthlyActionPlan {

//    public void doMonthlyActionPlan() {
//        System.out.println("Starting plan");
//        ActionPlanEmployee employeev2 = new ActionPlanEmployee("Ionut");
//
//        System.out.println("I am doing the plan:" + employeev2.getName());
//
//        employeev2.doJob();
//        employeev2.getSalary(1000);
//
//        System.out.println("Job is done");
//    }

    public void doMonthlyActionPlan() {
        System.out.println("Starting plan");
        ActionPlanPerson actionPlanPerson = getActionPlanPerson();

        System.out.println("I am doing the plan:" + actionPlanPerson.getName());

        actionPlanPerson.doJob();
        actionPlanPerson.getSalary(1000);

        System.out.println("Job is done");
    }

    public abstract ActionPlanPerson getActionPlanPerson();
}
