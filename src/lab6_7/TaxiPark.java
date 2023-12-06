package lab6_7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

class TaxiPark {
    private List < Car > cars = new ArrayList <> ( );
    private Random random = new Random ( );

    public void addCar ( Car car ) throws CarException {
        if (car == null) {
            throw new CarException ("Car cannot be null");
        }
        cars.add ( car );
    }

    public double calculateParkValue ( ) {
        double totalValue = 0;
        for ( Car car : cars ) {
            totalValue += car.getPrice ( );
        }
        return totalValue;
    }

    public void sortByFuelConsumption ( ) {
        cars.sort ( Comparator.comparingDouble ( Car::getFuelConsumption ) );
    }

    private double calcAvg(ArrayList < Double > prices){
        double counter = 0;
        for ( double value : prices ){
            counter += value;
        }
        return (double)Math.round ( (counter / prices.size()) * 100) / 100;
    }

    public void avgCost(){
        System.out.println ( "Average price for km" );
        ArrayList < Double > economPrices = new ArrayList <> ( );
        ArrayList < Double > comfortPrices = new ArrayList <> ( );
        ArrayList < Double > vanPrices = new ArrayList <> ( );
        ArrayList < Double > businessPrices = new ArrayList <> ( );
        for ( Car car : cars ) {
            switch ( car.getCarClass ( ) ) {
                case "Econom":
                    economPrices.add ( car.calcCostPerKm ( ) );
                    break;
                case "Comfort":
                    comfortPrices.add ( car.calcCostPerKm ( ) );
                    break;
                case "Van":
                    vanPrices.add ( car.calcCostPerKm ( ) );
                    break;
                default:
                    businessPrices.add ( car.calcCostPerKm ( ) );
                    break;
            }
        }


        System.out.println ("Econom class: $" + calcAvg ( economPrices ));
        System.out.println ("Comfort class: $" + calcAvg ( comfortPrices ));
        System.out.println ("Van class: $" + calcAvg ( vanPrices ));
        System.out.println ("Business class: $" + calcAvg ( businessPrices ));


    }

    public List < Car > findCarsInSpeedRange ( double minSpeed, double maxSpeed ) {
        List < Car > result = new ArrayList <> ( );
        for ( Car car : cars ) {
            if (car.getSpeed ( ) >= minSpeed && car.getSpeed ( ) <= maxSpeed) {
                result.add ( car );
            }
        }
        return result;
    }

    public List < Car > getCars ( ) {
        return cars;
    }

    public Car generateRandomCar ( ) throws CarException {
        String[] carClasses = {"Econom", "Comfort", "Van", "Business"};
        String selectedCarClass = carClasses[random.nextInt ( carClasses.length )];

        String brand;
        String model;
        double fuelConsumption;
        double price;
        double speed;

        switch ( selectedCarClass ) {
            case "Econom" -> {
                brand = getRandomBrand ( "Econom" );
                model = getRandomModel ( brand, "Econom" );
                fuelConsumption = Math.round((5.0 + random.nextDouble() * 5) * 10.0) / 10.0; // Випадкові витрати пального в діапазоні 5.0 - 10.0
                price = 10000 + random.nextInt ( 15000 ); // Випадкова ціна від 10000 до 25000
                speed = 100 + random.nextInt ( 20 ); // Випадкова швидкість від 100 до 120
            }
            case "Comfort" -> {
                brand = getRandomBrand ( "Comfort" );
                model = getRandomModel ( brand, "Comfort" );
                fuelConsumption = Math.round((6.0 + random.nextDouble() * 6) * 10.0) / 10.0; // Випадкові витрати пального в діапазоні 6.0 - 12.0
                price = 15000 + random.nextInt ( 20000 ); // Випадкова ціна від 15000 до 35000
                speed = 120 + random.nextInt ( 30 ); // Випадкова швидкість від 120 до 150
            }
            case "Van" -> {
                brand = getRandomBrand ( "Van" );
                model = getRandomModel ( brand, "Van" );
                fuelConsumption = Math.round((10.0 + random.nextDouble() * 8) * 10.0) / 10.0; // Випадкові витрати пального в діапазоні 10.0 - 18.0
                price = 20000 + random.nextInt ( 30000 ); // Випадкова ціна від 20000 до 50000
                speed = 90 + random.nextInt ( 20 ); // Випадкова швидкість від 90 до 110
            }
            default -> {  // Business
                brand = getRandomBrand ( "Business" );
                model = getRandomModel ( brand,  "Business");
                fuelConsumption = Math.round((7.0 + random.nextDouble() * 5) * 10.0) / 10.0; // Випадкові витрати пального в діапазоні 7.0 - 12.0
                price = 30000 + random.nextInt ( 50000 ); // Випадкова ціна від 30000 до 80000
                speed = 150 + random.nextInt ( 30 ); // Випадкова швидкість від 150 до 180
            }
        }

        Car randomCar = createCar ( selectedCarClass, brand, model, fuelConsumption, price, speed );
        return randomCar;
    }

    private String getRandomBrand ( String carClass ) {
        String[] brands;
        switch (carClass) {
            case "Econom":
                brands = new String[]{"Toyota", "Honda", "Ford", "Nissan", "Hyundai", "Chevrolet", "Mitsubishi"};
                break;
            case "Comfort":
                brands = new String[]{"Mazda", "Kia", "Subaru", "Volkswagen", "Volvo"};
                break;
            case "Van":
                brands = new String[]{"Mercedes-Benz", "Renault", "Fiat", "Peugeot", "Citroen"};
                break;
            default:
                brands = new String[]{"BMW", "Audi", "Lexus", "Jaguar", "Porsche"};
                break;
        }
        return brands[random.nextInt ( brands.length )];
    }

    private String getRandomModel ( String brand, String carClass) {
        String[] models;
        switch (carClass) {
            case "Econom":
                switch (brand) {
                    case "Toyota":
                        models = new String[]{"Corolla", "Yaris"};
                        break;
                    case "Honda":
                        models = new String[]{"Fit", "HR-V"};
                        break;
                    case "Ford":
                        models = new String[]{"Fiesta", "Focus"};
                        break;
                    case "Nissan":
                        models = new String[]{"Versa", "Sentra"};
                        break;
                    case "Hyundai":
                        models = new String[]{"Elantra", "Accent"};
                        break;
                    case "Chevrolet":
                        models = new String[]{"Cruze", "Spark"};
                        break;
                    case "Mitsubishi":
                        models = new String[]{"Mirage", "Outlander"};
                        break;
                    default:
                        models = new String[]{"UnknownModel1", "UnknownModel2", "UnknownModel3"};
                        break;
                }
                break;
            case "Comfort":
                switch (brand) {
                    case "Mazda":
                        models = new String[]{"Mazda3", "Mazda6"};
                        break;
                    case "Kia":
                        models = new String[]{"Optima", "Soul", "Sportage"};
                        break;
                    case "Subaru":
                        models = new String[]{"Impreza", "Outback"};
                        break;
                    case "Volkswagen":
                        models = new String[]{"Jetta", "Passat"};
                        break;
                    case "Volvo":
                        models = new String[]{"S60", "XC60"};
                        break;
                    default:
                        models = new String[]{"UnknownModel1", "UnknownModel2", "UnknownModel3"};
                        break;
                }
                break;
            case "Van":
                switch (brand) {
                    case "Mercedes-Benz":
                        models = new String[]{"Sprinter", "Metris"};
                        break;
                    case "Renault":
                        models = new String[]{"Kangoo", "Trafic"};
                        break;
                    case "Fiat":
                        models = new String[]{"Ducato", "Talento"};
                        break;
                    case "Peugeot":
                        models = new String[]{"Boxer", "Expert"};
                        break;
                    case "Citroen":
                        models = new String[]{"Jumper", "Jumpy"};
                        break;
                    default:
                        models = new String[]{"UnknownModel1", "UnknownModel2", "UnknownModel3"};
                        break;
                }
                break;
            default:
                switch (brand) {
                    case "BMW":
                        models = new String[]{"5 Series", "7 Series"};
                        break;
                    case "Audi":
                        models = new String[]{"A6", "A8"};
                        break;
                    case "Lexus":
                        models = new String[]{"ES", "LS"};
                        break;
                    case "Jaguar":
                        models = new String[]{"XE", "XF"};
                        break;
                    case "Porsche":
                        models = new String[]{"Panamera"};
                        break;
                    default:
                        models = new String[]{"UnknownModel1", "UnknownModel2", "UnknownModel3"};
                        break;
                }
                break;
        }
        return models[random.nextInt ( models.length )];
    }

    private Car createCar ( String carClass, String brand, String model, double fuelConsumption, double price, double speed ) throws CarException {
        switch ( carClass ) {
            case "Econom":
                return new Econom ( brand, model, fuelConsumption, price, speed );
            case "Comfort":
                return new Comfort ( brand, model, fuelConsumption, price, speed );
            case "Van":
                return new Van ( brand, model, fuelConsumption, price, speed );
            case "Business":
                return new Business ( brand, model, fuelConsumption, price, speed );
            default:
                throw new CarException ( "Invalid car class: " + carClass );
        }
    }
}
