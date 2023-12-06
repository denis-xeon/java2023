package lab8;

import lab6_7.Car;
import lab6_7.CarException;
import org.junit.Test;
import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void testConstructorValidParameters() throws CarException {
        Car car = new ConcreteCar("Toyota", "Camry", 8.5, 25000, 150, "Sedan");
        assertEquals("Toyota", car.getBrand());
        assertEquals("Camry", car.getModel());
        assertEquals(8.5, car.getFuelConsumption(), 0.01);
        assertEquals(25000, car.getPrice(), 0.01);
        assertEquals(150, car.getSpeed(), 0.01);
        assertEquals("Sedan", car.getCarClass());
    }

    @Test(expected = CarException.class)
    public void testConstructorNullBrand() throws CarException {
        new ConcreteCar(null, "Camry", 8.5, 25000, 150, "Sedan");
    }

    @Test(expected = CarException.class)
    public void testConstructorEmptyBrand() throws CarException {
        new ConcreteCar("", "Camry", 8.5, 25000, 150, "Sedan");
    }

    // Аналогічні тести для null/пустої моделі та carClass

    @Test(expected = CarException.class)
    public void testConstructorNegativeFuelConsumption() throws CarException {
        new ConcreteCar("Toyota", "Camry", -8.5, 25000, 150, "Sedan");
    }

    @Test(expected = CarException.class)
    public void testConstructorNegativePrice() throws CarException {
        new ConcreteCar("Toyota", "Camry", 8.5, -25000, 150, "Sedan");
    }

    @Test(expected = CarException.class)
    public void testConstructorNegativeSpeed() throws CarException {
        new ConcreteCar("Toyota", "Camry", 8.5, 25000, -150, "Sedan");
    }

    @Test
    public void testCalcCostPerKm() throws CarException {
        Car car = new ConcreteCar("Toyota", "Camry", 8.5, 25000, 150, "Sedan");
        assertEquals(2941.176470588235, car.calcCostPerKm(), 0.0001);
    }

    @Test
    public void testToString() throws CarException {
        Car car = new ConcreteCar("Toyota", "Camry", 8.5, 25000, 150, "Sedan");
        assertEquals("Car{brand='Toyota', model='Camry', fuelConsumption=8.5, price=25000.0, speed=150.0, carClass='Sedan'}", car.toString());
    }


    private static class ConcreteCar extends Car {
        public ConcreteCar(String brand, String model, double fuelConsumption, double price, double speed, String carClass) throws CarException {
            super(brand, model, fuelConsumption, price, speed, carClass);
        }

        @Override
        public double calcCostPerKm() {
            return getPrice() / getFuelConsumption();
        }
    }
}
