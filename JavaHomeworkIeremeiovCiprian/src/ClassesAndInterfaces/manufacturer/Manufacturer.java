/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesAndInterfaces.manufacturer;

/**
 *
 * @author Cip
 */
public class Manufacturer {
    
    private static int number_of_cars;
    
    private int lastIndex = 0;
    private final Car[] carList;
    private final String name;
    
    
    public Manufacturer(String name, int number) {
        carList = new Car[number];
        number_of_cars = number;
        this.name = name;
        System.out.printf("%s: There's a new manufacturer in town!\n", this.name);
    }
    
    public void produceCar(Car car) {
        if(lastIndex < (number_of_cars-1)) {
            carList[lastIndex] = car;
            System.out.printf("%s can now build %s\n",name, carList[lastIndex].getName());
            lastIndex++;
        } else {
            System.out.printf("%s has reached the maximum number of built cars!", name);
        }
    }
    
    /**
     * Prints a table with the CarDealer's cars and their properties
     */
    public void printCars() {
        System.out.print("\n      #Manufacturer: " + name );
        System.out.println("\n---------------------------------------------------------");
        System.out.printf("|%9s    |  %10s  | %14s  | %6s |\n", "Name", "Sale Price", "D_Rent Price",  "Color" );
        System.out.println("---------------------------------------------------------");

        for(int i = 0; i < lastIndex; i++) {
            System.out.printf("| %-12s|%14s|%17s| %-7s|\n",
                    carList[i].getName(), 
                    (carList[i].getSalePrice() > 0 )? (Integer.toString(carList[i].getSalePrice()) + "$") : "NOT_SET",
                    (carList[i].getDailyRentPrice() > 0) ? (Integer.toString(carList[i].getDailyRentPrice()) + "$") : "NOT_SET",
                    carList[i].getColor() );
        }
        System.out.println("---------------------------------------------------------");
    }

    // returns the car's index in the array of cars if it exists, otherwise it returns -1
    public int getCarIndex(Car car) {

        for(int i = 0; i < lastIndex; i++) {
            if(carList[i].getName().equals(car.getName())) {
                return i;
            }
        }          
        return -1;
    }
    
    public Car getCar(Car car) {
        return carList[getCarIndex(car)];
    }
    
    public Car getCar(int i) {
        return carList[i];
    }
    
    public String getName() {
        return name;
    }
    
    public int getLastIndex() {
        return lastIndex;
    }
    
}
