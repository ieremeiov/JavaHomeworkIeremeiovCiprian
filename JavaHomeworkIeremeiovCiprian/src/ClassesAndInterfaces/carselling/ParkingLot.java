/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesAndInterfaces.carselling;

/**
 *
 * @author Cip
 */
public class ParkingLot {
    
    private int noOfCars;
    private int lastIndex;
    private Car[] carList;
    
    /**
     *
     * @param number number of Car spots in the Parking Lot that is being created
     */
    public ParkingLot(int number) {
        noOfCars = number;
        carList = new Car[noOfCars];
        lastIndex = 0;
    }
    
    
    void addCar(String name, Car car) {
        if(lastIndex < noOfCars) {
            carList[lastIndex] = car;
            System.out.printf("%s parked %s in the parking lot.\n",name, carList[lastIndex].getName());
            lastIndex++;
            //System.out.println("Produced car: " + lastIndex);
        } else {
            System.out.printf("%s's parking lot is full.\n", name);
        }
    }
    
   
    int getNoOfCars() {
        return noOfCars;
    }

    
    int getLastIndex() {
        return lastIndex;
    }

    
    Car getCar(int i) {
        return carList[i];
    }

    
}
