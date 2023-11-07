package lab6;

class Comfort extends Car {
    public Comfort ( String brand, String model, double fuelConsumption, double price, double speed ) {
        super ( brand, model, fuelConsumption, price, speed, "Comfort" );
    }

    @Override
    public double calcCostPerKm() {
        return (double)Math.round ((getPrice() / 10000) * 100) / 100;
    }
}
