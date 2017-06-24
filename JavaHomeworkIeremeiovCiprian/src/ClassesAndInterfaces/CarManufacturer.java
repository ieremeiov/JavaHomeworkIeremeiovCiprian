/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesAndInterfaces;


/**
 *
 * @author Cip
 */
public class CarManufacturer {
    
    private static final int NUMBER_OF_CARS = 10;
    private static int currentIndex = 0;
    
    private String manufacturer;
    private Car[] manufacturedCar = new Car[NUMBER_OF_CARS];
    
    
    public CarManufacturer(String name) {
        manufacturer = name;
    }
    
    public void setSalePrice(Saleable car, int price) {
        int index = getCarIndex((Car)car);
        if(index >= 0) {
            manufacturedCar[index].setSalePrice(price);
        } else {
            System.out.println("This car is not built by this manufacturer.");
        }
    }
    
    public void setDailyRentPrice(Rentable car, int price) {
        int index = getCarIndex((Car)car);
        if(index >= 0) {
            manufacturedCar[index].setDailyRentPrice(price);
        } else {
            System.out.println("This car is not built by this manufacturer.");
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
    
    public String getName() {
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
