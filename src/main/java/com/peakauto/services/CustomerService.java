package main.java.com.peakauto.services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import main.java.com.peakauto.models.Customer;

public class CustomerService {
    private final List<Customer> customers;
    private int nextCustomerId;
    private final String filePath = "src/main/java/resources/customers.txt";

    public CustomerService() {
        this.customers = new ArrayList<>();
        this.nextCustomerId = 1;
        loadCustomers();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        nextCustomerId = Math.max(nextCustomerId, customer.getCustomerId() + 1);
        saveCustomers();
    }

    public void removeCustomer(int customerId) {
        boolean removed = customers.removeIf(customer -> customer.getCustomerId() == customerId);
        if (!removed) {
            System.out.println("Customer with ID " + customerId + " not found.");
        } else {
            System.out.println("Customer removed successfully!");
        }
        saveCustomers();
    }

    public void updateCustomerById(int id, Customer updatedCustomer) {
        int index = findCustomerIndexById(updatedCustomer.getCustomerId());
        if (index != -1) {
            customers.set(index, updatedCustomer);
            System.out.println("Customer updated successfully!");
        } else {
            System.out.println("Customer with ID " + updatedCustomer.getCustomerId() + " not found.");
        }
        saveCustomers();
    }

    public int getNextCustomerId() {
        return nextCustomerId++;
    }

    private int findCustomerIndexById(int customerId) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerId() == customerId) {
                return i;
            }
        }
        return -1;
    }

    private void loadCustomers() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    customers.add(new Customer(id, name, age));
                    nextCustomerId = Math.max(nextCustomerId, id + 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading customers: " + e.getMessage());
        }
    }

    private void saveCustomers() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Customer customer : customers) {
                bw.write(customer.getCustomerId() + "," + customer.getName() + "," + customer.getAge());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving customers: " + e.getMessage());
        }
    }

    public void removeCustomerById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
