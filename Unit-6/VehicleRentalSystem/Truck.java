public class Truck implements Vehicle, TruckVehicle {

    // Private variables
    private String make;
    private String model;
    private int year;
    private double cargoCapacity;
    private String transmissionType;

    // Default constructor
    public Truck() {
    }

    // Parameterized constructor
    public Truck(String make,
                 String model,
                 int year,
                 double cargoCapacity,
                 String transmissionType) {

        this.make = make;
        this.model = model;
        this.year = year;
        this.cargoCapacity = cargoCapacity;
        this.transmissionType = transmissionType;
    }

    // Vehicle methods
    @Override
    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void setYear(int year) {
        if (year > 1900 && year <= 2025) {
            this.year = year;
        } else {
            System.out.println("Invalid year.");
        }
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYear() {
        return year;
    }

    // TruckVehicle methods
    @Override
    public void setCargoCapacity(double capacity) {

        if (capacity > 0) {
            this.cargoCapacity = capacity;
        } else {
            System.out.println("Invalid cargo capacity.");
        }
    }

    @Override
    public void setTransmissionType(String transmission) {

        if (transmission.equalsIgnoreCase("Manual")
                || transmission.equalsIgnoreCase("Automatic")) {

            this.transmissionType = transmission;
        } else {
            System.out.println(
                    "Invalid transmission type.");
        }
    }

    @Override
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public String getTransmissionType() {
        return transmissionType;
    }

    // Display method
    public void displayTruckInfo() {

        System.out.println("\n===== Truck Details =====");
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Cargo Capacity: "
                + cargoCapacity + " tons");
        System.out.println("Transmission: "
                + transmissionType);
    }
}
