package main.java.com.peakauto.services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import main.java.com.peakauto.models.Employee;

public class EmployeeService {
    private final List<Employee> employees;
    private int nextEmployeeId;
    private final String filePath = "src/main/java/resources/employees.txt";

    public EmployeeService() {
        this.employees = new ArrayList<>();
        this.nextEmployeeId = 1;
        loadEmployees();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        nextEmployeeId = Math.max(nextEmployeeId, employee.getEmployeeId() + 1);
        saveEmployees();
    }

    public void removeEmployee(int employeeId) {
        Employee employeeToRemove = employees.stream()
            .filter(employee -> employee.getEmployeeId() == employeeId)
            .findFirst()
            .orElse(null);

        if (employeeToRemove != null) {
            employees.remove(employeeToRemove);
            System.out.println("Employee removed successfully!");
        } else {
            System.out.println("Employee with ID " + employeeId + " not found.");
        }
        saveEmployees();
    }

    public void updateEmployeeById(int id, Employee updatedEmployee) {
        int index = findEmployeeIndexById(updatedEmployee.getEmployeeId());
        if (index != -1) {
            employees.set(index, updatedEmployee);
            System.out.println("Employee updated successfully!");
        } else {
            System.out.println("Employee with ID " + updatedEmployee.getEmployeeId() + " not found.");
        }
        saveEmployees();
    }

    public int getNextEmployeeId() {
        return nextEmployeeId++;
    }

    private int findEmployeeIndexById(int employeeId) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeId() == employeeId) {
                return i;
            }
        }
        return -1;
    }

    private void loadEmployees() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    employees.add(new Employee(id, name, age));
                    nextEmployeeId = Math.max(nextEmployeeId, id + 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading employees: " + e.getMessage());
        }
    }

    private void saveEmployees() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Employee employee : employees) {
                bw.write(employee.getEmployeeId() + "," + employee.getName() + "," + employee.getAge());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }

    public void removeEmployeeById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
