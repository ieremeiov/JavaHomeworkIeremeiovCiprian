/*
 *   
 *
 */
package ClassesAndInterfaces.manufacturer;

import ClassesAndInterfaces.Interfaces.Rentable;
import ClassesAndInterfaces.Interfaces.Renter;
import ClassesAndInterfaces.Interfaces.Saleable;
import ClassesAndInterfaces.Interfaces.Seller;

/**
 * CarDealer Class that has a list of manufacturers with cars for sale/rent;
 *
 * @author Cip
 */
public class CarDealer implements Seller, Renter{

    private static int numberOfManufacturers;

    private int lastIndex = 0;
    private final String carDealer;
    private final Manufacturer[] manufacturerList;

    /**
     * Constructor for Manufacturer
     *
     * @param name sets the name for the Car Dealer
     * @param number sets the maximum number of manufacturers for that specific Car Dealer
     */
    public CarDealer(String name, int number) {
        carDealer = name;
        numberOfManufacturers = number;
        manufacturerList = new Manufacturer[number];
        System.out.printf("%s: There's a new Car Dealer in town!\n", carDealer);
    }

    /**
     * Can set SalePrice for any Saleable car built by a specific manufacturer.
     *
     * @param manufacturer
     * @param car the car whose sell price you want to set
     * @param price the sell price you want to set for the car
     */
    @Override
    public void setSalePrice(Manufacturer manufacturer, Saleable car, int price) {
        Car newCar = (Car) car;
        
        int manIndex = getManufacturerIndex(manufacturer);
        if (manIndex >= 0) {
            int carIndex = manufacturer.getCarIndex((Car) car);
            if (carIndex >= 0) {
                manufacturerList[manIndex].getCar(carIndex).setSalePrice(price);
            } else {
                System.out.printf("%s is not in %s's list.\n", manufacturer.getName(), carDealer);
            }
        } else {
            System.out.printf("%s is not built by %s\n", newCar.getName(), manufacturer);
        }
    }

    /**
     * Can set DailyRentPrice for any Rentable car built by a specific manufacturer.
     *
     * @param manufacturer
     * @param car the car whose daily rent price you want to set
     * @param price the daily rent price you want to set for the car
     */
    @Override
    public void setDailyRentPrice(Manufacturer manufacturer, Rentable car, int price) {
        Car newCar = (Car) car;
        
        int manIndex = getManufacturerIndex(manufacturer);
        if (manIndex >= 0) {
            int carIndex = manufacturer.getCarIndex((Car) car);
            if (carIndex >= 0) {
                manufacturerList[manIndex].getCar(carIndex).setDailyRentPrice(price);
            } else {
                System.out.printf("%s is not in %s's list.\n", manufacturer.getName(), carDealer);
            }
        } else {
            System.out.printf("%s is not built by %s\n", newCar.getName(), manufacturer);
        }
    }

    /**
     * Adds a manufacturer to the manufacturer list, only if the list is not already full.
     *
     * @param manufacturer manufacturer to add
     */
    public void addManufacturer(Manufacturer manufacturer) {
        if (lastIndex < (numberOfManufacturers)) {
            manufacturerList[lastIndex] = manufacturer;
            lastIndex++;
            System.out.printf("%s can now sell cars for %s\n", carDealer, manufacturer.getName());
        } else {
            System.out.printf("%s has reached the maximum number of manufacturers.\n", carDealer);
        }
    }

    /**
     *
     * @return the index of the last car in the array of cars
     */
    public int getLastIndex() {
        return lastIndex;
    }

    /**
     *
     * @return name of the car dealer
     */
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
    
    /**
     * Prints a list of cars for each manufacturer in the dealer's list, alongside with the car's selling/renting price if it exists.
     */
    public void printCars() {
        
        System.out.printf("\nDealer <%s> is selling/renting:\n", carDealer);
        for(int i=0; i < lastIndex; i++) { 
            System.out.printf("     <%s> : \n", manufacturerList[i].getName() );

            for(int j = 0; j < manufacturerList[i].getLastIndex(); j++) {
                System.out.printf("          <%s: %s/%s> \n", manufacturerList[i].getCar(j).getName(), 
                                                  (manufacturerList[i].getCar(j).getSalePrice() > 0) ? Integer.toString(manufacturerList[i].getCar(j).getSalePrice()) : "NOT_SET", 
                                                  (manufacturerList[i].getCar(j).getDailyRentPrice()> 0) ? Integer.toString(manufacturerList[i].getCar(j).getDailyRentPrice()) : "NOT_SET"
                                                  );
            }
        }
        System.out.println("");
    }

    /**
     * Prints a list of manufacturers that the dealer is selling for.
     */
    public void printManufacturers() {
        
        System.out.print("\n" + this.getName() + " is selling cars for ");
        for(int i = 0; i < lastIndex; i++) {
            System.out.printf("<%s> ", manufacturerList[i].getName());
        }
        System.out.println("");
        
    }
    
}
