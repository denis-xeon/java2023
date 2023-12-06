package lab6_7;

public abstract class Car {
    private String brand;
    private String model;
    private double fuelConsumption;
    private double price;
    private double speed;
    private String carClass;

    public Car ( String brand, String model, double fuelConsumption, double price, double speed, String carClass ) throws CarException {

        if (brand == null || model == null || carClass == null || brand.isEmpty() || model.isEmpty() || carClass.isEmpty()) {
            throw new CarException("Brand, model, and carClass cannot be null or empty");
        }

        if (fuelConsumption < 0 || price < 0 || speed < 0) {
            throw new CarException("Fuel consumption, price, and speed cannot be negative");
        }

        this.brand = brand;
        this.model = model;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
        this.speed = speed;
        this.carClass = carClass;
    }

    public Car ( String model ) {

    }

    public abstract double calcCostPerKm();

    public String getBrand ( ) {
        return brand;
    }

    public String getModel ( ) {
        return model;
    }

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

//    @Override
//    public String toString ( ) {
//        return String.format ( "| %-8s | %-15s | %-15s | %-17s | $%-9s | %-12s | $%-11s |", carClass, brand, model, fuelConsumption + "l/100km", price, speed + "km/h", calcCostPerKm () );
//    }

    @Override
    public String toString ( ) {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", fuelConsumption=" + fuelConsumption +
                ", price=" + price +
                ", speed=" + speed +
                ", carClass='" + carClass + '\'' +
                '}';
    }
}
