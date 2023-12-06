package lab6_7;

class Econom extends Car {
    public Econom ( String brand, String model, double fuelConsumption, double price, double speed ) throws CarException {
        super ( brand, model, fuelConsumption, price, speed, "Econom" );
    }

    @Override
    public double calcCostPerKm() {
        return (double)Math.round ((getPrice() / 14000) * 100) / 100;
    }

}
