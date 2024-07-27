package main.java.com.peakauto.models;

public class Employee extends Person {
    private int employeeId;

    public Employee(int employeeId, String name, int age) {
        super(name, age);
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + "\n" +
               "Name: " + getName() + "\n" +
               "Age: " + getAge() + "\n";
    }
}
