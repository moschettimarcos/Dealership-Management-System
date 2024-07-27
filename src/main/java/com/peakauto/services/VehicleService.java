package main.java.com.peakauto.services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import main.java.com.peakauto.models.Car;
import main.java.com.peakauto.models.Motorcycle;
import main.java.com.peakauto.models.Vehicle;

public class VehicleService {
    private final List<Vehicle> vehicles;
    private final String filePath = "src/main/java/resources/vehicles.txt";

    public VehicleService() {
        this.vehicles = new ArrayList<>();
        loadVehicles();
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        saveVehicles();
    }

    public void updateVehicleByPlate(String currentPlate, Vehicle updatedVehicle) {
        int index = findVehicleIndexByPlate(currentPlate);
        if (index != -1) {
            vehicles.set(index, updatedVehicle);
            System.out.println("Vehicle updated successfully!");
        } else {
            System.out.println("Vehicle with plate " + currentPlate + " not found.");
        }
        saveVehicles();
    }

    public void removeVehicle(String plate) {
        boolean removed = vehicles.removeIf(vehicle -> vehicle.getPlate().equals(plate));
        if (removed) {
            System.out.println("Vehicle removed successfully!");
        } else {
            System.out.println("Vehicle with plate " + plate + " not found.");
        }
        saveVehicles();
    }

    private int findVehicleIndexByPlate(String plate) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getPlate().equals(plate)) {
                return i;
            }
        }
        return -1;
    }

    private void loadVehicles() {
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File not found: " + filePath);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Reading line: " + line);  // Debugging output
                String[] parts = line.split(",");
                
                if (parts.length >= 4) {
                    String type = parts[0];
                    String plate = parts[1];
                    String brand = parts[2];
                    String model = parts[3];
                    
                    switch (type) {
                        case "Car" -> {
                            if (parts.length == 5) {
                                String fuelType = parts[4];
                                vehicles.add(new Car(plate, brand, model, fuelType));
                            } else {
                                System.out.println("Skipping line (invalid Car data): " + line);
                            }
                        }
                        case "Motorcycle" -> {
                            if (parts.length == 5) {
                                String bikeType = parts[4];
                                vehicles.add(new Motorcycle(plate, brand, model, bikeType));
                            } else {
                                System.out.println("Skipping line (invalid Motorcycle data): " + line);
                            }
                        }
                        default -> System.out.println("Unknown vehicle type: " + type);
                    }
                } else {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading vehicles: " + e.getMessage());
        }
    }

    private void saveVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles to save.");
            return;
        }
    
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Vehicle vehicle : vehicles) {
                if (vehicle != null) {  // Check if vehicle is not null
                    switch (vehicle) {
                        case Car car -> 
                            bw.write("Car," + car.getPlate() + "," + car.getBrand() + "," + car.getModel() + "," + car.getFuelType());
                        case Motorcycle motorcycle -> 
                            bw.write("Motorcycle," + motorcycle.getPlate() + "," + motorcycle.getBrand() + "," + motorcycle.getModel() + "," + motorcycle.getType());
                        default -> 
                            System.out.println("Unknown vehicle type: " + vehicle.getClass().getName());
                    }
                    bw.newLine(); // Add a new line after each vehicle
                } else {
                    System.out.println("Encountered a null vehicle object.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving vehicles: " + e.getMessage());
        }
    }
}
