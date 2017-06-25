/*
 * Car Manufacturers are selling and renting cars. 
 */
package ClassesAndInterfaces;

import ClassesAndInterfaces.manufacturer.Manufacturer;
import ClassesAndInterfaces.manufacturer.Car;

/**
 * Manufacturer has a list of Cars that are Rentable and Saleable.
 * The Cars have attributes like Name, Speed, Color, Sale Price, Daily Rent Price.
 * 
 * 
 * @author Cip
 */
public class Cars {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Car ferrari = new Car("Ferrari", (short)180, Car.Color.GREEN);
        
        

        Manufacturer manufacturer = new Manufacturer("Dacia");
        Car logan = new Car("Logan", (short)160, Car.Color.WHITE);
        Car mercedes = new Car("Mercedes", (short)230, Car.Color.YELLOW);
        Car bmw = new Car("BMW", (short)220, Car.Color.BLACK);
        
        manufacturer.addCar(bmw);
        manufacturer.addCar(logan);
        manufacturer.addCar(mercedes);

        // set the price for a car that is not in the list?
        manufacturer.setSalePrice(ferrari, 56000);
        
        manufacturer.setSalePrice(logan, 8000);
        manufacturer.setSalePrice(mercedes, 28000);
        manufacturer.setSalePrice(bmw, 26000);

        
        manufacturer.setDailyRentPrice(logan, 200);
        manufacturer.setDailyRentPrice(mercedes, 500);
        
        System.out.println("Logan's sale price is: " + logan.getSalePrice());
        System.out.println("Mercedes' daily rent price is: " + mercedes.getDailyRentPrice());
        
        manufacturer.printCars();
        System.out.println("NOTE: Table says I can rent BMW for free. I have  to fix this.");
        
    }
    
}
