/*
 *   
 *
 */
package ClassesAndInterfaces.manufacturer;

/**
 * CarDealer Class that has a list of manufacturers with cars for sale/rent;
 *
 * @author Cip
 */
public class CarDealer {

    private static int numberOfManufacturers;

    public static int getNumberOfManufacturers() {
        return numberOfManufacturers;
    }

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
        parking = new ParkingLot(number);
        System.out.printf("%s: There's a new Car Dealer in town!\n", this.name);
    }
    
    public static CarDealer createCarDealer(String name, int noManufacturers) {
        return new CarDealer(name, noManufacturers);
    }

   
    public void setSalePrice(String carName, int price) {
        Car car = getCar(carName);
        car.setSalePrice(price);
        
    }
    
    public void setPaintPrice(String carName, int price) {
        Car car = getCar(carName);
        car.setPaintPrice(price);
    }

    
    public void setDailyRentPrice(String carName, int price) {
        Car car = getCar(carName);
        car.setDailyRentPrice(price);
        
    }
   
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
    
    public Car getCar(String car) {
        return parking.getCar(getCarIndex(car));
    }
     
    int getCarIndex(String car) {
        for(int i = 0; i < parking.getLastIndex(); i++) {
            if(parking.getCar(i).getName().equals(car)) {
                return i;
            }
        }          
        return -1;
    }

    /**
     *
     * @return name of the car dealer
     */
    public String getName() {
        return name;
    }

   
    public void printCarLabel() {
        System.out.printf("\nDEALER <%s> HAS: \n", name);
        for(int i=0; i < parking.getLastIndex(); i++) { 
            System.out.println("#" + (i+1));
                Car car = parking.getCar(i);
                System.out.println(car.printLabel());
        }
        System.out.println("");
    }

    
    public void sellCar(String car) {
        Car carToSell = getCar(car);
        if(carToSell != null) {
            carToSell.sellCar();
        } else {
            System.out.println("Car not found");
        }
    }
    
    public void rentCar(String car) {
        Car carToRent = getCar(car);
        if(carToRent != null) {
            carToRent.rentCar();
        } else {
            System.out.println("Car not found");
        }
    }
    
    public void paintCar(String car, Label.Color color) {
        Car carToPaint = getCar(car);
        carToPaint.paintCar(color);
    }
    
    
    
}
