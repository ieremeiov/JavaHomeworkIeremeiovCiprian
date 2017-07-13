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
public class ParkingLot {
    
    private int noOfCars;
    private int lastIndex;
    private Car[] carList;
    
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
    
    public int getNoOfCars() {
        return noOfCars;
    }

    public int getLastIndex() {
        return lastIndex;
    }

    public Car getCar(int i) {
        return carList[i];
    }

    public void setNoOfCars(int noOfCars) {
        this.noOfCars = noOfCars;
    }

    public void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }

    public void setCarList(Car[] carList) {
        this.carList = carList;
    }
    
    
    
}
