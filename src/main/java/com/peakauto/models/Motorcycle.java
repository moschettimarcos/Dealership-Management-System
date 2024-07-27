package main.java.com.peakauto.models;

public class Motorcycle extends Vehicle {
    private final String type;

    public Motorcycle(String plate, String brand, String model, String type) {
        super(plate, brand, model);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return """
               Motorcycle
               Plate: """ + getPlate() + "\n" +
               "Brand: " + getBrand() + "\n" +
               "Model: " + getModel() + "\n" +
               "Type: " + getType() + "\n";
    }
    
}
