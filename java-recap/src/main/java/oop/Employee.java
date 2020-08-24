package oop;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee implements Payable, Taxable{

    private Long id;
    private String name;
    private String title;
    private BigDecimal salary;
    protected String protectedVariable;

    public Employee(String name, String title, BigDecimal salary) {
        this.name = name;
        this.title = title;
        this.salary = salary;
    }

    public Employee(Long id, String name, String title, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.salary = salary;
    }

    public Employee() {}

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(final BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public void paySalary(final BigDecimal salary) {
        System.out.println("Payed employed: " + salary);
    }

    @Override
    public BigDecimal getTaxes() {
        return this.salary.multiply(BigDecimal.valueOf(0.2));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(title, employee.title) &&
                Objects.equals(salary, employee.salary) &&
                Objects.equals(protectedVariable, employee.protectedVariable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, title, salary, protectedVariable);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", salary=" + salary +
                ", protectedVariable='" + protectedVariable + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}
