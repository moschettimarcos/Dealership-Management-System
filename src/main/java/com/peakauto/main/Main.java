package main.java.com.peakauto.main;

import java.util.List;
import java.util.Scanner;
import main.java.com.peakauto.models.Car;
import main.java.com.peakauto.models.Customer;
import main.java.com.peakauto.models.Employee;
import main.java.com.peakauto.models.Motorcycle;
import main.java.com.peakauto.models.Vehicle;
import main.java.com.peakauto.services.CustomerService;
import main.java.com.peakauto.services.EmployeeService;
import main.java.com.peakauto.services.VehicleService;

public class Main {
    private final CustomerService customerService;
    private final EmployeeService employeeService;
    private final VehicleService vehicleService;
    private final Scanner scanner;

    public static void main(String[] args) {
        new Main().run();
    }

    public Main() {
        this.customerService = new CustomerService();
        this.employeeService = new EmployeeService();
        this.vehicleService = new VehicleService();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Dealership Management System");

        while (true) {
            showMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1 -> addVehicle();
                case 2 -> addCustomer();
                case 3 -> addEmployee();
                case 4 -> listVehicle();
                case 5 -> listCustomer();
                case 6 -> listEmployee();
                case 7 -> updateVehicle();
                case 8 -> updateCustomer();
                case 9 -> updateEmployee();
                case 10 -> removeVehicle();
                case 11 -> removeCustomer();
                case 12 -> removeEmployee();
                case 0 -> {
                    System.out.println("Exiting the program...");
                    return;
                }
                default -> System.out.println("Invalid option, please choose a valid option.");
            }
        }
    }

    public void showMenu() {
        System.out.println("\n======MENU======");
        System.out.println("1. Vehicle Registration");
        System.out.println("2. Customer Registration");
        System.out.println("3. Employee Registration");
        System.out.println("4. List Vehicles");
        System.out.println("5. List Customers");
        System.out.println("6. List Employees");
        System.out.println("7. Edit Vehicle");
        System.out.println("8. Edit Customer");
        System.out.println("9. Edit Employee");
        System.out.println("10. Remove Vehicle");
        System.out.println("11. Remove Customer");
        System.out.println("12. Remove Employee");
        System.out.println("0. Exit");
    }

    private void addVehicle() {
        System.out.println("\n====== Vehicle Registration ======");
        System.out.println("Select vehicle type:");
        System.out.println("1. Car");
        System.out.println("2. Motorcycle");
        int type = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Plate: ");
        String plate = scanner.nextLine();

        switch (type) {
            case 1 -> {
                System.out.print("Fuel Type: ");
                String fuelType = scanner.nextLine();
                Car newCar = new Car(plate, brand, model, fuelType);
                vehicleService.addVehicle(newCar);
                System.out.println("Car registered successfully!");
            }
            case 2 -> {
                System.out.print("Bike Type: ");
                String bikeType = scanner.nextLine();
                Motorcycle newMotorcycle = new Motorcycle(plate, brand, model, bikeType);
                vehicleService.addVehicle(newMotorcycle);
                System.out.println("Motorcycle registered successfully!");
            }
            default -> System.out.println("Invalid vehicle type selected.");
        }
    }

    private void addCustomer() {
        System.out.println("\n====== Customer Registration ======");
        System.out.print("Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        int newCustomerId = customerService.getNextCustomerId();
        Customer newCustomer = new Customer(newCustomerId, name, age);
        customerService.addCustomer(newCustomer);
        System.out.println("Customer registered successfully!");
    }

    private void addEmployee() {
        System.out.println("\n====== Employee Registration ======");
        System.out.print("Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        int newEmployeeId = employeeService.getNextEmployeeId();
        Employee newEmployee = new Employee(newEmployeeId, name, age);
        employeeService.addEmployee(newEmployee);
        System.out.println("Employee registered successfully!");
    }

    public void listVehicle() {
        System.out.println("\n====== List Vehicles ======");
        List<Vehicle> vehicles = vehicleService.getVehicles();

        // Debugging output
        System.out.println("Number of vehicles loaded: " + vehicles.size());

        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available.");
        } else {
            vehicles.forEach(vehicle -> {
                System.out.println(vehicle);
                System.out.println();
            });
        }
    }

    public void listCustomer() {
        System.out.println("\n====== List Customers ======");
        List<Customer> customers = customerService.getCustomers();
        if (customers.isEmpty()) {
            System.out.println("No customers available.");
        } else {
            customers.forEach(customer -> {
                System.out.println(customer);
                System.out.println(); // Adiciona uma linha em branco após cada cliente
            });
        }
    }
    

    public void listEmployee() {
        System.out.println("\n====== List Employees ======");
        List<Employee> employees = employeeService.getEmployees();
        if (employees.isEmpty()) {
            System.out.println("No employees available.");
        } else {
            employees.forEach(employee -> {
                System.out.println(employee);
                System.out.println(); // Adiciona uma linha em branco após cada funcionário
            });
        }
    }
    
    private void updateVehicle() {
        System.out.println("\n====== Update Vehicle ======");
        System.out.print("Enter plate of the vehicle to update: ");
        String plate = scanner.nextLine();

        System.out.print("New Brand: ");
        String brand = scanner.nextLine();
        System.out.print("New Model: ");
        String model = scanner.nextLine();
        System.out.print("New Plate: ");
        String newPlate = scanner.nextLine();

        System.out.println("Select new vehicle type:");
        System.out.println("1. Car");
        System.out.println("2. Motorcycle");
        int type = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (type) {
            case 1 -> {
                System.out.print("New Fuel Type: ");
                String fuelType = scanner.nextLine();
                Vehicle updatedVehicle = new Car(newPlate, brand, model, fuelType);
                vehicleService.updateVehicleByPlate(plate, updatedVehicle);
                System.out.println("Vehicle updated successfully!");
            }
            case 2 -> {
                System.out.print("New Bike Type: ");
                String bikeType = scanner.nextLine();
                Vehicle updatedVehicle = new Motorcycle(newPlate, brand, model, bikeType);
                vehicleService.updateVehicleByPlate(plate, updatedVehicle);
                System.out.println("Vehicle updated successfully!");
            }
            default -> System.out.println("Invalid vehicle type selected.");
        }
    }

    private void updateCustomer() {
        System.out.println("\n====== Update Customer ======");
        System.out.print("Enter ID of the customer to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("New Name: ");
        String name = scanner.nextLine();
        System.out.print("New Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Customer updatedCustomer = new Customer(id, name, age);
        customerService.updateCustomerById(id, updatedCustomer);
        System.out.println("Customer updated successfully!");
    }

    private void updateEmployee() {
        System.out.println("\n====== Update Employee ======");
        System.out.print("Enter ID of the employee to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("New Name: ");
        String name = scanner.nextLine();
        System.out.print("New Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Employee updatedEmployee = new Employee(id, name, age);
        employeeService.updateEmployeeById(id, updatedEmployee);
        System.out.println("Employee updated successfully!");
    }

    private void removeVehicle() {
        System.out.println("\n====== Remove Vehicle ======");
        System.out.print("Enter plate of the vehicle to remove: ");
        String plate = scanner.nextLine();
        vehicleService.removeVehicle(plate);
    }

    private void removeCustomer() {
        System.out.println("\n====== Remove Customer ======");
        System.out.print("Enter ID of the customer to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        customerService.removeCustomerById(id);
    }

    private void removeEmployee() {
        System.out.println("\n====== Remove Employee ======");
        System.out.print("Enter ID of the employee to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        employeeService.removeEmployeeById(id);
    }
}
