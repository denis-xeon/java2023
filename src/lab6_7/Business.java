package lab6_7;

class Business extends Car {
    public Business ( String brand, String model, double fuelConsumption, double price, double speed ) throws CarException {
        super ( brand, model, fuelConsumption, price, speed, "Business" );
    }

    @Override
    public double calcCostPerKm() {
        return (double)Math.round ((getPrice() / 5000) * 100) /100;
    }
}
