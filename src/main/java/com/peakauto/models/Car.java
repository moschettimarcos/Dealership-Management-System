package main.java.com.peakauto.models;

public class Car extends Vehicle {
    private final String fuelType;

    public Car(String plate, String brand, String model, String fuelType) {
        super(plate, brand, model);
        this.fuelType = fuelType;
    }

    public String getFuelType() {
        return fuelType;
    }

    @Override
    public String toString() {
        return """
               Car
               Plate: """ + getPlate() + "\n" +
               "Brand: " + getBrand() + "\n" +
               "Model: " + getModel() + "\n" +
               "Fuel Type: " + getFuelType() + "\n";
    }
    
}
