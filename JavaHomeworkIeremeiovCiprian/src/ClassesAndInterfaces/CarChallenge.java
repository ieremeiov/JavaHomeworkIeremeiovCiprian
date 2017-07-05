/*
 * Car Dealers are selling and renting cars built by Car Manufacturers. 
 */
package ClassesAndInterfaces;

import ClassesAndInterfaces.manufacturer.Car;
import ClassesAndInterfaces.manufacturer.CarDealer;
import ClassesAndInterfaces.manufacturer.Manufacturer;

/**
 * Car Dealer has a list of CarChallenge that are Rentable and Saleable. They set the Sale Price and Daily Rent Price of cars.
 Car Manufacturer has a list of built cars. They set the Name, Speed and Color of the Car.
 The CarChallenge have attributes like Name, Speed, Color, Sale Price, Daily Rent Price.
 * 
 * 
 * @author Cip
 */
public class CarChallenge {

    /**
     * @param args the command line arguments N/A
     */
    public static void main(String[] args) {

        
        CarDealer dealer1 = CarDealer.createCarDealer("Dealer1", 2);
        Manufacturer manufacturer1 = Manufacturer.createManufacturer("Manufacturer1", 4);
        Manufacturer manufacturer2 = Manufacturer.createManufacturer("Manufacturer2", 3);
        
        manufacturer1.produceCar("Car1", (short)230, Car.Color.YELLOW);
        manufacturer1.produceCar("Car2", (short)230, Car.Color.YELLOW);
        manufacturer1.produceCar("Car3", (short)230, Car.Color.RED);
        manufacturer1.produceCar("Car4", (short)230, Car.Color.YELLOW);
        manufacturer1.produceCar("Car41", (short)230, Car.Color.YELLOW); // Car List is already full
        
        manufacturer2.produceCar("Car5", (short)230, Car.Color.YELLOW);
        
        dealer1.addManufacturer(manufacturer1);
        dealer1.addManufacturer(manufacturer2);
        
        dealer1.setSalePrice(manufacturer1, "Car1", 20000);
        dealer1.setDailyRentPrice(manufacturer1, "Car1", 100);
        dealer1.setSalePrice(manufacturer1, "Car2", 25000);
        dealer1.setSalePrice(manufacturer2, "Car5", 30000);
       
        dealer1.setSalePrice(manufacturer2, "Car2", 30000); // not in car list of manufacturer
       
        manufacturer1.printCars();
        manufacturer2.printCars();
        
        dealer1.printManufacturers();
        dealer1.printCars();

    }
    
}
