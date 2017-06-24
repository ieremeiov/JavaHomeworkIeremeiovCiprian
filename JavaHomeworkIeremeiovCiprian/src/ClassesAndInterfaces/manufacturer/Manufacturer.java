/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesAndInterfaces.manufacturer;

import ClassesAndInterfaces.Rentable;
import ClassesAndInterfaces.Saleable;
import ClassesAndInterfaces.manufacturer.Car;


/**
 *
 * @author Cip
 */
public class Manufacturer {
    
    private static final int NUMBER_OF_CARS = 10;
    private static int currentIndex = 0;
    
    private final String manufacturer;
    private final Car[] manufacturedCar = new Car[NUMBER_OF_CARS];
    
    
    public Manufacturer(String name) {
        manufacturer = name;
    }
    
    public void setSalePrice(Saleable car, int price) {
        Car newCar = (Car)car;
        int index = getCarIndex((Car)car);
        if(index >= 0) {
            manufacturedCar[index].setSalePrice(price);
        } else {
            System.out.printf("%s is not built by %s\n", newCar.getName(), manufacturer);
        }
    }
    
    public void setDailyRentPrice(Rentable car, int price) {
        int index = getCarIndex((Car)car);
        if(index >= 0) {
            manufacturedCar[index].setDailyRentPrice(price);
        } else {
            System.out.printf("%s", "This car is not build by this manufacturer.\n");
        }
    }
    
    public void printCars() {
        System.out.print("\n      #Manufacturer: " + manufacturer );
        System.out.println("\n----------------------------------------------------------");
        System.out.printf("|%-13s|%-12s|%-18s|%-10s|\n", "Name", "Sale Price", "Daily Rent Price",  "Color" );

        for(int i = 0; i < currentIndex; i++) {
            System.out.printf("|%-13s|%-12d|%-18d|%-10s|\n",
                    manufacturedCar[i].getName(), 
                    manufacturedCar[i].getSalePrice(),
                    manufacturedCar[i].getDailyRentPrice(), 
                    manufacturedCar[i].getColor() );
        }
        System.out.println("----------------------------------------------------------");
    }
    
    public void addCar(Car car) {
        manufacturedCar[currentIndex] = car;
        currentIndex++;
    }
    
    public static int getCurrentIndex() {
        return currentIndex;
    }
    
    private String getName() {
        return manufacturer;
    }
    
    private int getCarIndex(Car car) {

        for(int i = 0; i < currentIndex; i++) {
            if(manufacturedCar[i].getName().equals(car.getName())) {
                return i;
            }
        }          
        return -1;
    }
    
    
    
}
