package main.java.com.peakauto.models;

public class Customer extends Person {
    private int customerId;

    public Customer(int customerId, String name, int age) {
        super(name, age);
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    @Override
    public String toString() {
        return "Customer ID: " + customerId + "\n" +
               "Name: " + getName() + "\n" +
               "Age: " + getAge() + "\n";
    }
}
