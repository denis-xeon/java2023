package lab6_7;

public class Lab6 {
    public static void main(String[] args) throws CarException {

        final int C13 = 1517 % 13;// 9
        System.out.println("C13 = " + C13 + " /Визначити ієрархію легкових автомобілів. Створити таксопарк. Порахувати" +
                "вартість автопарку. Провести сортування автомобілів парку за витратами" +
                "палива. \nЗнайти автомобіль у компанії, що відповідає заданому діапазону" +
                "швидкості автомобіля.");

        TaxiPark taxiPark = new TaxiPark ( );

        for ( int i = 0 ; i < 3 ; i++ ) {
            taxiPark.addCar ( taxiPark.generateRandomCar ( ) );
        }

        double parkValue = taxiPark.calculateParkValue ( );
        System.out.println ( "Total value of the taxi park: $" + parkValue );

        taxiPark.sortByFuelConsumption ( );
        System.out.println ( "Cars sorted by fuel consumption:" );
        System.out.printf ( "| %-8s | %-15s | %-15s | %-17s | %-10s | %-12s | %-12s |%n", "Class", "Brand", "Model", "Fuel consumption", "Price", "Speed", "Cost per km" );
        System.out.println ( "|----------|-----------------|-----------------|-------------------|------------|--------------|--------------|" );
        for ( Car car : taxiPark.getCars ( ) ) {
            System.out.println ( car );
            System.out.println ( "|----------|-----------------|-----------------|-------------------|------------|--------------|--------------|" );
        }

        System.out.println ( "Cars in speed range (100-140 km/h):" );
        System.out.printf ( "| %-8s | %-15s | %-15s | %-17s | %-10s | %-12s | %-12s |%n", "Class", "Brand", "Model", "Fuel consumption", "Price", "Speed", "Cost per km" );
        System.out.println ( "|----------|-----------------|-----------------|-------------------|------------|--------------|--------------|" );
        for ( Car car : taxiPark.findCarsInSpeedRange ( 100, 140 ) ) {
            System.out.println ( car );
            System.out.println ( "|----------|-----------------|-----------------|-------------------|------------|--------------|--------------|" );
        }

        taxiPark.avgCost ();

        Car car1 = new Comfort ("Brand1", "Model1", 8.5, 20000, 120);
//        Car car2 = new Van("Car", "Model1", -8.5, 20000, -120);
//        Car car2 = new Business ("Brand2", "Model2", 7.5, 25000, 150);
//        Car car3 = new Econom ("Brand3", "Model3", 10.0, 18000, 100);
//
//        // Створюємо список об'єктів Car
//        List<Car> carList = new ArrayList<>();
//        carList.add(car1);
//        carList.add(car2);
//        carList.add(car3);

        DoublyLinkedListSet<Car> carCollection1 = new DoublyLinkedListSet<Car> (  );
        System.out.println (carCollection1.isEmpty () );

        DoublyLinkedListSet<Car> carCollection2 = new DoublyLinkedListSet <> ( car1 );
//
        DoublyLinkedListSet<Car> carCollection3 = new DoublyLinkedListSet <> ( taxiPark.getCars () );
//
        System.out.println("Collection 1 size: " + carCollection1.size());
        System.out.println ( "Collection 1 content: " + carCollection1);

        System.out.println("Collection 2 size: " + carCollection2.size());
        System.out.println("Collection 2 content: " + carCollection2);
        carCollection2.remove ( car1 );
        System.out.println("Collection 2 content: " + carCollection2);
        carCollection2.add(car1);
        System.out.println("Collection 2 content: " + carCollection2);
//
        System.out.println("Collection 3 size: " + carCollection3.size());
        System.out.println("Collection 3 content: " + carCollection3);




    }
}
