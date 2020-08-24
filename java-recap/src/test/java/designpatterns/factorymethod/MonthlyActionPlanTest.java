package designpatterns.factorymethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonthlyActionPlanTest {

    @Test
    public void doMonthlyActionPlan() {
        MonthlyActionPlan monthlyActionPlan = new EmployeeMonthlyActionPlan();

        monthlyActionPlan.doMonthlyActionPlan();
    }

}
