/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesAndInterfaces.manufacturer;

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
    public Car() {
        label = new Label();
    }

    public Car(String manufacturer, String carName) {
        label = new Label(manufacturer, carName);
    }

    public Car(String manufacturer, String name, Label.Color color) {
        label = new Label(manufacturer, name, color);
    }

    /**
     *
     * @return
     */
    public String getName() {
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
    public short getMaxSpeed() {
        return label.getMaxSpeed();
    }

    public void paintCar(Label.Color color) {
        label.setColor(color);
    }

    public void sellCar() {
        if (label.isRented()) {
            System.out.println("Car is rented at this moment");
        } else if(label.isSold()) {
            System.out.println("Car is already Sold");
        } else {
            label.setIsSold(true);
        }
    }

    public void rentCar() {
        if (label.isSold()) {
            System.out.println("Car is sold");
        } else if(label.isRented()) {
            System.out.println("Car is already Rented");
        } else {
            label.setIsRented(true);
        }
    }

    public void tuneUp(short newSpeed) {
        if (newSpeed > label.getMaxSpeed()) {
            label.setMaxSpeed(newSpeed);
        }
    }

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

    public int getPaintPrice() {
        return label.getPaintPrice();
    }

    public String printLabel() {
        return label.toString();
    }

}
