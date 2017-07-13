
package ClassesAndInterfaces.carselling;

/**
 * the Manufacturer builds the cars with a name, max speed and color; these specs can be chosen by them or by the CarDealer
 * @author Cip
 */
public class Manufacturer {
    
    private ParkingLot parking;
    private final String name;
    
    
    private Manufacturer(String name, int number) {
        this.name = name;
        buildParkingLot(number);
        System.out.printf("%s: There's a new manufacturer in town!\n", this.name);
    }
    
    /**
     *
     * @param name brand's name
     * @param noCars maximum number of cars in the ParkingLot
     * @return a a new Manufacturer with specified name and number of spots in the parking lot.
     */
    public static Manufacturer createManufacturer(String name, int noCars) {
        return new Manufacturer(name, noCars);
    }
    
    
    /**
     * After production, the Car is parked in the Manufacturer's ParkingLot
     * @param carName name of the Car to be produced
     * @param carColor 
     * @return  
     */
    public Car produceCar(String carName, Label.Color carColor) {
        Car car =  new Car(this.name, carName, carColor);
        System.out.println(name + " produced " + carName + " of " + carColor + " color");
        parkCar(car);
        return car;
    }
    
    
    private void buildParkingLot(int number) {
        parking = new ParkingLot(number);
    }
    
    
    private void parkCar(Car car) {
        parking.addCar(name, car);
    }
    
    
    /**
     * Prints a table with the Manufacturer's cars with their Specs.
     */
    public void printCarSpecs() {
        System.out.print("\n      #Manufacturer: " + name );
        System.out.println("\n------------------------------------------------");
        System.out.printf("|%9s    |  %10s  |   %8s      |\n", "Model", "Max Speed",  "Color" );
        System.out.println("------------------------------------------------");

        for(int i = 0; i < parking.getLastIndex(); i++) {
            System.out.printf("| %-12s| %-13s| %-16s|\n",
                    parking.getCar(i).getName(), 
                    Short.toString(parking.getCar(i).getMaxSpeed()),
                    parking.getCar(i).getColor() );
        }
        System.out.println("------------------------------------------------");
    }

   
    int getCarIndex(String car) {
        for(int i = 0; i < parking.getLastIndex(); i++) {
            if(parking.getCar(i).getName().equals(car)) {
                return i;
            }
        }          
        return -1;
    }
    
    
    int getCarIndex(String car, Label.Color color) {
        for(int i = 0; i < parking.getLastIndex(); i++) {
            Car searchCar = parking.getCar(i);
            if(searchCar.getName().equals(car) && searchCar.getColor().equals(color)) {
                return i;
            }
        }          
        return -1;
    }
   
    
    Car getCar(String car) {
        int index = getCarIndex(car);
        if(index != -1) {
            return parking.getCar(index);
        } else {
            return null;
        }
    }
    
    
     Car getCar(String car, Label.Color color) {
        int index = getCarIndex(car, color);
        if(index != -1) {
            return parking.getCar(index);
        } else {
            return null;
        }
    }
    
     
    /**
     *
     * @param i
     * @return the car at index i in the carList of manufacturer
     */
    Car getCar(int i) {
        return parking.getCar(i);
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
     * @return number of cars in the Parking Lot
     */
    int getNoOfCars() {
        return parking.getNoOfCars();
    }


    
}
