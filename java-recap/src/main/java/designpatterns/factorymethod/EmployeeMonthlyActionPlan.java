package designpatterns.factorymethod;

public class EmployeeMonthlyActionPlan extends MonthlyActionPlan{
    @Override
    public ActionPlanPerson getActionPlanPerson() {
        return new ActionPlanEmployee("Ionut");
    }
}
