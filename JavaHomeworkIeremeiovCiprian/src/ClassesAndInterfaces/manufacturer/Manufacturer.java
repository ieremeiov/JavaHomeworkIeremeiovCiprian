
package ClassesAndInterfaces.manufacturer;

/**
 *
 * @author Cip
 */
public class Manufacturer {
    
    private final int noOfCars;
    private int lastIndex = 0;
    private final Car[] carList;
    private final String name;
    
    /**
     *
     * @param name Manufacturer's name
     * @param number maximum number of cars
     */
    private Manufacturer(String name, int number) {
        carList = new Car[number];
        noOfCars = number;
        this.name = name;
        System.out.printf("%s: There's a new manufacturer in town!\n", this.name);
    }
    
    public static Manufacturer createManufacturer(String name, int noCars) {
        return new Manufacturer(name, noCars);
    }
    
    /**
     *
     * @param carName name of the Car to be produced
     * @param carSpeed 
     * @param carColor 
     */
    public void produceCar(String carName, short carSpeed, Car.Color carColor) {
        Car car =  new Car(carName, carSpeed, carColor);
        addCar(car);
    }
        
    private void addCar(Car car) {
        
        if(lastIndex < (noOfCars)) {
            carList[lastIndex] = car;
            System.out.printf("%s can now build %s\n",name, carList[lastIndex].getName());
            lastIndex++;
            //System.out.println("Produced car: " + lastIndex);
        } else {
            System.out.printf("%s has reached the maximum number of built cars!\n", name);
        }
    }
    
    /**
     * Prints a table with the Manufacturer's cars with their name, color and the sale price/rent price set by their contracted Car Dealer.
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

    /**
     *
     * @param car the Car object to search for
     * @return the index of the car in the manufacturer's carList
     */
    int getCarIndex(Car car) {

        for(int i = 0; i < lastIndex; i++) {
            if(carList[i].getName().equals(car.getName())) {
                return i;
            }
        }          
        return -1;
    }
    
    /**
     *
     * @param car the name of the Car object to search for
     * @return the index of the car in the manufacturer's carList
     */
    int getCarIndex(String car) {

        for(int i = 0; i < lastIndex; i++) {
            if(carList[i].getName().equals(car)) {
                return i;
            }
        }          
        return -1;
    }
    
    /**
     *
     * @param car
     * @return
     */
    Car getCar(Car car) {
        return carList[getCarIndex(car)];
    }
    
    /**
     *
     * @param i
     * @return the car at index i in the carList of manufacturer
     */
    Car getCar(int i) {
        return carList[i];
    }
    
    /**
     *
     * @return
     */
    String getName() {
        return name;
    }
    
    /**
     *
     * @return
     */
    int getLastIndex() {
        return lastIndex;
    }
    
    /**
     *
     * @return
     */
    int getNoOfCars() {
        return noOfCars;
    }
    
}
