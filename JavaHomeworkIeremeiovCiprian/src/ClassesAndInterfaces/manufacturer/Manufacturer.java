/*
 *   
 *
 */
package ClassesAndInterfaces.manufacturer;

import ClassesAndInterfaces.Rentable;
import ClassesAndInterfaces.Saleable;


/**
 * Manufacturer Class that has a list of cars that he is manufacturing and a name;
 * @author Cip
 */
public class Manufacturer {
    
    //NUMBER_OF_CARS is the maximum number of cars that the manufacturer can build
    private static final int NUMBER_OF_CARS = 10;
    private static int lastIndex = 0;
    
    private final String manufacturer;
    private final Car[] manufacturedCar = new Car[NUMBER_OF_CARS];
    
    /**
     * Constructor for Manufacturer
     * @param name sets the name for the Manufacturer
     */
    public Manufacturer(String name) {
        manufacturer = name;
    }
    
    /**
     * Can set SalePrice for any Saleable car.
     * @param car the car whose sell price you want to set
     * @param price the sell price you want to set for the car
     */
    public void setSalePrice(Saleable car, int price) {
        Car newCar = (Car)car;
        int index = getCarIndex((Car)car);
        if(index >= 0) {
            manufacturedCar[index].setSalePrice(price);
        } else {
            System.out.printf("%s is not built by %s\n", newCar.getName(), manufacturer);
        }
    }
    
    /**
     * Can set DailyRentPrice for any Rentable car.
     * @param car car the car whose daily rent price you want to set
     * @param price the daily rent price you want to set for the car
     */
    public void setDailyRentPrice(Rentable car, int price) {
        int index = getCarIndex((Car)car);
        if(index >= 0) {
            manufacturedCar[index].setDailyRentPrice(price);
        } else {
            System.out.printf("%s", "This car is not build by this manufacturer.\n");
        }
    }
    
    /**
     * Prints a table with the Manufacturer's cars and their properties
     */
    public void printCars() {
        System.out.print("\n      #Manufacturer: " + manufacturer );
        System.out.println("\n-----------------------------------------------------------");
        System.out.printf("|%9s    |  %10s | %14s   | %6s   |\n", "Name", "Sale Price", "D_Rent Price",  "Color" );
        System.out.println("-----------------------------------------------------------");

        for(int i = 0; i < lastIndex; i++) {
            System.out.printf("| %-12s|%,13d$|%,18d$| %-7s|\n",
                    manufacturedCar[i].getName(), 
                    manufacturedCar[i].getSalePrice(),
                    manufacturedCar[i].getDailyRentPrice(), 
                    manufacturedCar[i].getColor() );
        }
        System.out.println("-----------------------------------------------------------");
    }
    
    /**
     *
     * @param car the Car you want to add to this manufacturer's Car list
     */
    public void addCar(Car car) {
        manufacturedCar[lastIndex] = car;
        lastIndex++;
    }
    
    /**
     * 
     * @return the index of the last car in the array of cars
     */
    public static int getLastIndex() {
        return lastIndex;
    }
    
    private String getName() {
        return manufacturer;
    }
    
    // returns the car's index in the array of cars if it exists, otherwise it returns -1
    private int getCarIndex(Car car) {

        for(int i = 0; i < lastIndex; i++) {
            if(manufacturedCar[i].getName().equals(car.getName())) {
                return i;
            }
        }          
        return -1;
    }
    
    
    
}
