package lab6_7;

class Van extends Car {
    public Van ( String brand, String model, double fuelConsumption, double price, double speed ) throws CarException {
        super ( brand, model, fuelConsumption, price, speed, "Van" );
    }

    @Override
    public double calcCostPerKm() {
        return (double)Math.round ((getPrice() / 7000) * 100) /100;
    }
}
