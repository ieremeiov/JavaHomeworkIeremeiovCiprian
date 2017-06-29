/*
 *   
 *
 */
package ClassesAndInterfaces.manufacturer;

import ClassesAndInterfaces.Rentable;
import ClassesAndInterfaces.Saleable;

/**
 * CarDealer Class that has a list of cars that he is manufacturing and a name;
 *
 * @author Cip
 */
public class CarDealer {

    //NUMBER_OF_CARS is the maximum number of cars that the carDealer can build
    private static int number_of_manufacturers;
    
    private int lastIndex = 0;
    private final String carDealer;
    private final Manufacturer[] manufacturerList;

    /**
     * Constructor for Manufacturer
     *
     * @param name sets the name for the Manufacturer
     * @param number
     */
    public CarDealer(String name, int number) {
        carDealer = name;
        number_of_manufacturers = number;
        manufacturerList = new Manufacturer[number];
        System.out.printf("%s: There's a new Car Dealer in town!\n", carDealer);
    }

    /**
     * Can set SalePrice for any Saleable car.
     *
     * @param manufacturer
     * @param car the car whose sell price you want to set
     * @param price the sell price you want to set for the car
     */
    public void setSalePrice(Manufacturer manufacturer, Saleable car, int price) {
        Car newCar = (Car) car;
        
        int manIndex = getManufacturerIndex(manufacturer);
        if (manIndex >= 0) {
            int carIndex = manufacturer.getCarIndex((Car) car);
            if (carIndex >= 0) {
                manufacturerList[manIndex].getCarList()[carIndex].setSalePrice(price);
            } else {
                System.out.printf("%s is not in %s's list.\n", manufacturer.getName(), carDealer);
            }
        } else {
            System.out.printf("%s is not built by %s\n", newCar.getName(), manufacturer);
        }
    }

    /**
     * Can set DailyRentPrice for any Rentable car.
     *
     * @param manufacturer
     * @param car car the car whose daily rent price you want to set
     * @param price the daily rent price you want to set for the car
     */
    public void setDailyRentPrice(Manufacturer manufacturer, Rentable car, int price) {
        Car newCar = (Car) car;
        
        int manIndex = getManufacturerIndex(manufacturer);
        if (manIndex >= 0) {
            int carIndex = manufacturer.getCarIndex((Car) car);
            if (carIndex >= 0) {
                manufacturerList[manIndex].getCarList()[carIndex].setDailyRentPrice(price);
            } else {
                System.out.printf("%s is not in %s's list.\n", manufacturer.getName(), carDealer);
            }
        } else {
            System.out.printf("%s is not built by %s\n", newCar.getName(), manufacturer);
        }
    }

    /**
     * Adds a car to the car list, only if the list is not already full.
     *
     * @param manufacturer
     */
    public void addManufacturer(Manufacturer manufacturer) {
        if (lastIndex < (number_of_manufacturers - 1)) {
            manufacturerList[lastIndex] = manufacturer;
            lastIndex++;
            System.out.printf("%s can now sell cars for %s\n", carDealer, manufacturer.getName());
        } else {
            System.out.printf("%s has reached the maximum number of manufacturers.", carDealer);
        }
    }

    /**
     *
     * @return the index of the last car in the array of cars
     */
    public int getLastIndex() {
        return lastIndex;
    }

    public String getName() {
        return carDealer;
    }

    private int getManufacturerIndex(Manufacturer manufacturer) {

        for (int i = 0; i < lastIndex; i++) {
            if (manufacturerList[i].getName().equals(manufacturer.getName())) {
                return i;
            }
        }
        return -1;
    }
    
    public void printCars() {
        
        System.out.printf("\n Dealer <%s> is selling/renting:\n", carDealer);
        for(int i=0; i < lastIndex; i++) { 
            System.out.printf(" <%s> : ", manufacturerList[i].getName() );
            System.out.printf("<%s: %s/%s> \n", manufacturerList[i].getCar(0).getName(), 
                                                  (manufacturerList[i].getCar(0).getSalePrice() > 0) ? Integer.toString(manufacturerList[i].getCar(0).getSalePrice()) : "NOT_SET", 
                                                  (manufacturerList[i].getCar(0).getDailyRentPrice()> 0) ? Integer.toString(manufacturerList[i].getCar(0).getDailyRentPrice()) : "NOT_SET"
                                                  );
            for(int j = 1; j < manufacturerList[i].getLastIndex(); j++) {
                for(int space = 0; space < (manufacturerList[i].getName().length() + 6); space++) {
                    System.out.print(" ");
                }
                System.out.printf("<%s: %s/%s> \n", manufacturerList[i].getCar(j).getName(), 
                                                  (manufacturerList[i].getCar(j).getSalePrice() > 0) ? Integer.toString(manufacturerList[i].getCar(j).getSalePrice()) : "NOT_SET", 
                                                  (manufacturerList[i].getCar(j).getDailyRentPrice()> 0) ? Integer.toString(manufacturerList[i].getCar(j).getDailyRentPrice()) : "NOT_SET"
                                                  );
            }
        }
        System.out.println("");
    }

    public void printManufacturers() {
        
        System.out.print("\n" + this.getName() + " is selling cars for ");
        for(int i = 0; i < lastIndex; i++) {
            System.out.printf("<%s> ", manufacturerList[i].getName());
        }
        System.out.println("");
        
    }
    
}
