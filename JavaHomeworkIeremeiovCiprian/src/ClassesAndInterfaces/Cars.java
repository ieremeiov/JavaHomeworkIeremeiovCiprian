/*
 * Car Manufacturers are selling and renting cars. 
 */
package ClassesAndInterfaces;

import ClassesAndInterfaces.manufacturer.Car;
import ClassesAndInterfaces.manufacturer.CarDealer;
import ClassesAndInterfaces.manufacturer.Manufacturer;

/**
 * CarDealer has a list of Cars that are Rentable and Saleable.
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

        
        CarDealer dealer1 = new CarDealer("Dealer1", 5);
        Manufacturer manufacturer1 = new Manufacturer("Manufacturer1", 4);
        Manufacturer manufacturer2 = new Manufacturer("Manufacturer2", 4);
        Car car1 = new Car("Car1", (short)230, Car.Color.YELLOW);
        Car car2 = new Car("Car2", (short)230, Car.Color.YELLOW);
        Car car3 = new Car("Car3", (short)230, Car.Color.RED);
        
        manufacturer1.produceCar(car1);
        manufacturer1.produceCar(car2);
        manufacturer2.produceCar(car3);
        
        dealer1.addManufacturer(manufacturer1);
        dealer1.addManufacturer(manufacturer2);
        
        dealer1.setSalePrice(manufacturer1, car1, 20000);
        dealer1.setDailyRentPrice(manufacturer1, car1, 100);
        dealer1.setSalePrice(manufacturer1, car2, 25000);
        dealer1.setSalePrice(manufacturer2, car3, 30000);
       
        dealer1.setSalePrice(manufacturer2, car2, 30000); // not in list
       

        manufacturer1.printCars();
        manufacturer2.printCars();
        
        dealer1.printManufacturers();

        dealer1.printCars();

        
    }
    
}
