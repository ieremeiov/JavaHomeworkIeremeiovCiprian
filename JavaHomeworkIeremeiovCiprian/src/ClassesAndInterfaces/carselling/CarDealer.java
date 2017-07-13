/*
 *   
 *
 */
package ClassesAndInterfaces.carselling;

/**
 * CarDealer Class that can have a ParkingLot built, can set prices and modify Cars, and also sell/rent them
 *
 * @author Cip
 */
public class CarDealer {

    private final String name;
    private ParkingLot parking;

    
    /**
     * Constructor for Manufacturer
     *
     * @param name sets the name for the Car Dealer
     * @param number sets the maximum number of manufacturers for that specific Car Dealer
     */
    private CarDealer(String name, int number) {
        this.name = name;
        buildParkingLot(number);
        System.out.printf("%s: There's a new Car Dealer in town!\n", this.name);
    }
    
    /**
     *
     * @param name the name of the Car Dealer
     * @param noCars the number of cars in the dealer's parking lot
     * @return the specified Car Dealer
     */
    public static CarDealer createCarDealer(String name, int noCars) {
        return new CarDealer(name, noCars);
    }
    
    private void buildParkingLot(int number) {
        parking = new ParkingLot(number);
    }

    /**
     *
     * @param carName model of the Car 
     * @param price the Sale Price to set
     */
    public void setSalePrice(String carName, int price) {
        Car car = getCar(carName);
        car.setSalePrice(price);
        
    }
    
    /**
     *
     * @param carName model of the Car
     * @param price the repainting price to set
     */
    public void setPaintPrice(String carName, int price) {
        Car car = getCar(carName);
        car.setPaintPrice(price);
    }

    /**
     *
     * @param carName model of the Car
     * @param price the Daily Rent Price to set
     */
    public void setDailyRentPrice(String carName, int price) {
        Car car = getCar(carName);
        car.setDailyRentPrice(price);
    }
   
    /**
     *
     * @param manufacturer the manufacturer that you send the request to
     * @param car the Car you wish to get from the manufacturer
     * @param color the color of the Car 
     */
    public void requestCar(Manufacturer manufacturer, String car, Label.Color color) {
        if (manufacturer != null) {
            Car newCar = manufacturer.getCar(car, color);
            System.out.printf("%s requested %s for %s painted in %s \n", name, manufacturer.getName(), car, color);
            if (newCar != null) {
                parkCar(newCar);
            } else {
                parkCar(manufacturer.produceCar(car, color));
            }
        } else {
            System.out.println("Unknown manufacturer!");
        }
    }

    
    private void parkCar(Car car) {
        parking.addCar(name, car);
    }
    
    private Car getCar(String car) {
        return parking.getCar(getCarIndex(car));
    }
     
    private int getCarIndex(String car) {
        for(int i = 0; i < parking.getLastIndex(); i++) {
            if(parking.getCar(i).getName().equals(car)) {
                return i;
            }
        }          
        return -1;
    }


    /**
     * prints the Labels of every Car in the Dealer's ParkingLot
     */
    public void printCarLabel() {
        System.out.printf("\nDEALER <%s> CAR LABELS: \n", name);
        for(int i=0; i < parking.getLastIndex(); i++) { 
            System.out.println("<Car #" + (i+1) + ">");
                Car car = parking.getCar(i);
                System.out.println(car.printLabel());
        }
        System.out.println("");
    }

    /**
     *
     * @param car the Car to sell
     */
    public void sellCar(String car) {
        Car carToSell = getCar(car);
        if(carToSell != null) {
            carToSell.sellCar();
        } else {
            System.out.println("Car not found");
        }
    }
    
    /**
     *
     * @param car the Car to rent
     */
    public void rentCar(String car) {
        Car carToRent = getCar(car);
        if(carToRent != null) {
            carToRent.rentCar();
        } else {
            System.out.println("Car not found");
        }
    }
    
    /**
     *
     * @param car the Car to repaint
     * @param newColor the new color you want for the car
     */
    public void paintCar(String car, Label.Color newColor) {
        Car carToPaint = getCar(car);
        carToPaint.paintCar(newColor);
    }
   
    
}
