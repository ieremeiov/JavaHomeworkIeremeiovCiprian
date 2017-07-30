/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesAndInterfaces.carselling;

import ClassesAndInterfaces.Interfaces.Paintable;
import ClassesAndInterfaces.Interfaces.Rentable;
import ClassesAndInterfaces.Interfaces.Saleable;

/**
 *
 * @author Cip
 */
public class Car implements Saleable, Rentable, Paintable {

    private Label label;

    /**
     * Constructors
     */
    Car() {
        label = new Label();
    }

    /**
     *
     * @param manufacturer
     * @param carName
     */
    Car(String manufacturer, String carName) {
        label = new Label(manufacturer, carName);
    }

    /**
     *
     * @param manufacturer
     * @param name
     * @param color
     */
    Car(String manufacturer, String name, Label.Color color) {
        label = new Label(manufacturer, name, color);
    }

    
    /**
     *
     * @return
     */
    String getName() {
        return label.getName();
    }

    /**
     *
     * @return
     */
    public Label.Color getColor() {
        return label.getColor();
    }

    
    /**
     *
     * @return the car's current speed
     */
    short getMaxSpeed() {
        return label.getMaxSpeed();
    }

    /**
     *
     * @param color
     */
    @Override
    public void getPainted(Label.Color color) {
        label.setColor(color);
    }

    /**
     *
     */
    @Override
    public void getSold() {
        if (label.isRented()) {
            System.out.println("Car is rented at this moment");
        } else if(label.isSold()) {
            System.out.println("Car is already Sold");
        } else {
            label.setIsSold(true);
        }
    }

    /**
     *
     */
    @Override
    public void getRented() {
        if (label.isSold()) {
            System.out.println("Car is sold");
        } else if(label.isRented()) {
            System.out.println("Car is already Rented");
        } else {
            label.setIsRented(true);
        }
    }

    /**
     *
     * @param newSpeed the Car's Max Speed that you want to increase to
     */
    public void tuneUp(short newSpeed) {
        if (newSpeed > label.getMaxSpeed()) {
            label.setMaxSpeed(newSpeed);
        }
    }

    /**
     *
     * @param newSpeed the Car's Max Speed that you want to decrease to
     */
    public void tuneDown(short newSpeed) {
        if (newSpeed < label.getMaxSpeed()) {
            label.setMaxSpeed(newSpeed);
        }
    }

    
    /**
     * Abstract method defined in Saleable interface implemented by class car is
     * implemented here.
     *
     * @override Saleable.getSalePrice() method
     */
    @Override
    public int getSalePrice() {
        if (label.getSalePrice() > 0) {
            return label.getSalePrice();
        } else {
            return -1;
        }
    }

    
    /**
     * Abstract method defined in Rentable interface implemented by class car is
     * implemented here.
     *
     * @override Rentable.getDailyRentPrice() method
     */
    @Override
    public int getDailyRentPrice() {
        if (label.getDailyRentPrice() > 0) {
            return label.getDailyRentPrice();
        } else {
            return -1;
        }
    }

    
    // method used by the manufacturer to set the Sale Price
    void setSalePrice(int price) {
        label.setSalePrice(price);
    }

    
    // method used by the manufacturer to set the Daily Rent Price
    void setDailyRentPrice(int price) {
        label.setDailyRentPrice(price);
    }

    
    void setPaintPrice(int price) {
        label.setPaintPrice(price);
    }

    /**
     * Abstract method defined in Paintable interface implemented by class car is
     * implemented here.
     *
     * @return 
     * @override Paintable.PaintPrice() method
     */
    public int getPaintPrice() {
        return label.getPaintPrice();
    }

    /**
     *
     * @return
     */
    String printLabel() {
        return label.toString();
    }

}
