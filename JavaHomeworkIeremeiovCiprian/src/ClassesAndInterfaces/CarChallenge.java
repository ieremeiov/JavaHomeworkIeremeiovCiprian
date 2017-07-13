/*
 * Car Dealers are selling and renting cars built by Car Manufacturers. 
 */
package ClassesAndInterfaces;

import ClassesAndInterfaces.carselling.CarDealer;
import ClassesAndInterfaces.carselling.Label;
import ClassesAndInterfaces.carselling.Manufacturer;

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

        
        CarDealer dealer1 = CarDealer.createCarDealer("DEALER_1", 7);
        Manufacturer manufacturer1 = Manufacturer.createManufacturer("MANUFACTURER_1", 6);
        Manufacturer manufacturer2 = Manufacturer.createManufacturer("MANUFACTURER_2", 3);
        System.out.println("----------------------------------------------------");
        
        manufacturer1.produceCar("CAR1", Label.Color.YELLOW);
//        manufacturer1.produceCar("CAR2", Label.Color.GREEN);
//        manufacturer1.produceCar("CAR3", Label.Color.RED);
//        manufacturer1.produceCar("CAR4", Label.Color.YELLOW);
//        manufacturer1.produceCar("CAR41", Label.Color.YELLOW); // Car List is already full
//        
//        manufacturer2.produceCar("CAR5", Label.Color.YELLOW);
        
        System.out.println("----------------------------------------------------");
        
        dealer1.requestCar(manufacturer1, "CAR1", Label.Color.YELLOW);
        System.out.println("----------------------------------------------------");
        dealer1.requestCar(manufacturer1, "CAR2", Label.Color.GREEN);
        dealer1.requestCar(manufacturer2, "CAR6", Label.Color.WHITE);
        
        dealer1.setSalePrice("CAR1", 20000);
        dealer1.setDailyRentPrice("CAR1", 100);
        dealer1.setSalePrice("CAR2", 25000);
        dealer1.setDailyRentPrice("CAR2", 150);
      //  dealer1.setSalePrice("CAR5", 30000);
        
        dealer1.setPaintPrice("CAR1", 220);
        dealer1.setPaintPrice("CAR2", 250);
       
       manufacturer1.printCarSpecs();
      //  System.out.println("----------------------------------------------------");
     //  manufacturer2.printCars();
     //   System.out.println("----------------------------------------------------");
     
        dealer1.sellCar("CAR1");
        dealer1.rentCar("CAR2");
        dealer1.rentCar("CAR6");
        dealer1.paintCar("CAR6", Label.Color.BLACK);
        
        dealer1.printCarLabel();

    }
    
}
