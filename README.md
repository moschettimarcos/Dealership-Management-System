# Dealership Management System

## Overview

The Dealership Management System is a Java-based application designed to manage the operations of a car dealership. It allows users to register and manage vehicles, customers, and employees. This system supports functionalities such as adding, updating, listing, and removing records of vehicles, customers, and employees.

## Project Structure

The project is organized into the following directories:

- `src/main/java/com/peakauto/main/`: Contains the `Main` class which serves as the entry point for the application.
- `src/main/java/com/peakauto/models/`: Contains the model classes for `Vehicle`, `Car`, `Motorcycle`, `Customer`, `Employee`, and `Person`.
- `src/main/java/com/peakauto/services/`: Contains the service classes for managing `Vehicle`, `Customer`, and `Employee` operations.

## Features

- **Vehicle Management**:

  - Register new vehicles (Cars and Motorcycles).
  - Update vehicle details.
  - List all vehicles.
  - Remove vehicles from the system.

- **Customer Management**:

  - Register new customers.
  - Update customer details.
  - List all customers.
  - Remove customers from the system.

- **Employee Management**:
  - Register new employees.
  - Update employee details.
  - List all employees.
  - Remove employees from the system.

## Usage

1. **Running the Application**:

   - Compile and run the `Main` class to start the application.

2. **Interacting with the Application**:

   - Use the menu options to navigate through the different functionalities:
     - `1`: Vehicle Registration
     - `2`: Customer Registration
     - `3`: Employee Registration
     - `4`: List Vehicles
     - `5`: List Customers
     - `6`: List Employees
     - `7`: Edit Vehicle
     - `8`: Edit Customer
     - `9`: Edit Employee
     - `10`: Remove Vehicle
     - `11`: Remove Customer
     - `12`: Remove Employee
     - `0`: Exit

3. **Data Persistence**:
   - Data is saved in text files located in the `src/main/java/resources/` directory:
     - `customers.txt`
     - `employees.txt`
     - `vehicles.txt`

## Requirements

- Java 11 or higher

## Contributing

Contributions are welcome! Please follow these guidelines for submitting pull requests:

1. Create a branch for your feature or bug fix.
2. Add tests for new features or fixes.
3. Submit a pull request with a clear description of the changes.

If you need any further changes or additions, just let me know!

Feel free to submit issues or pull requests. Please follow the project's coding style and test thoroughly before submitting changes.

## Contact

For any questions or feedback, please reach out to [marcosmoscheti@gmail.com](mailto:marcosmoscheti@gmail.com).
