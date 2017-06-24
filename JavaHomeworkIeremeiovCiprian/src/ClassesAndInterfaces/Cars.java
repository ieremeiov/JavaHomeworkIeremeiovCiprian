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
public class Cars {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       Car ferrari = new Car("ferrari", (short)180, Car.Color.GREEN);
        
        

        CarManufacturer manufacturer = new CarManufacturer("Dacia");
        Car logan = new Car("Logan", (short)160, Car.Color.WHITE);
        Car mercedes = new Car("Mercedes", (short)230, Car.Color.YELLOW);
        Car bmw = new Car("BMW", (short)220, Car.Color.BLACK);
        
        manufacturer.addCar(bmw);
        manufacturer.addCar(logan);
        manufacturer.addCar(mercedes);

        
        manufacturer.setSalePrice(logan, 8000);
        manufacturer.setSalePrice(mercedes, 28000);
        manufacturer.setSalePrice(ferrari, 56000);
        manufacturer.setSalePrice(bmw, 26000);

        
        manufacturer.setDailyRentPrice(logan, 200);
        manufacturer.setDailyRentPrice(mercedes, 500);
        
        System.out.println(logan.getSalePrice());
        System.out.println(mercedes.getSalePrice());
        
        manufacturer.printCars();
        

        
    }
    
}
