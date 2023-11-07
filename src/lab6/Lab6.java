package lab6;

import java.util.ArrayList;

public class Lab6 {
    public static void main(String[] args) {

        final int C13 = 1517 % 13;// 9
        System.out.println("C13 = " + C13 + " /Визначити ієрархію легкових автомобілів. Створити таксопарк. Порахувати" +
                "вартість автопарку. Провести сортування автомобілів парку за витратами" +
                "палива. \nЗнайти автомобіль у компанії, що відповідає заданому діапазону" +
                "швидкості автомобіля.");

        TaxiPark taxiPark = new TaxiPark ( );

        for ( int i = 0 ; i < 10 ; i++ ) {
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




    }
}
