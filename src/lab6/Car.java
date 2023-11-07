package lab6;

abstract class Car {
    private String brand;
    private String model;
    private double fuelConsumption;
    private double price;
    private double speed;
    private String carClass;

    public Car ( String brand, String model, double fuelConsumption, double price, double speed, String carClass ) {
        this.brand = brand;
        this.model = model;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
        this.speed = speed;
        this.carClass = carClass;
    }

    public abstract double calcCostPerKm();

    public String getCarClass ( ) {
        return carClass;
    }

    public double getFuelConsumption ( ) {
        return fuelConsumption;
    }

    public double getPrice ( ) {
        return price;
    }

    public double getSpeed ( ) {
        return speed;
    }

    @Override
    public String toString ( ) {
        return String.format ( "| %-8s | %-15s | %-15s | %-17s | $%-9s | %-12s | $%-11s |", carClass, brand, model, fuelConsumption + "l/100km", price, speed + "km/h", calcCostPerKm () );
    }
}
