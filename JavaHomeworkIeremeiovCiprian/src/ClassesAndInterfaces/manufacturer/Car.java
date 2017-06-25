/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesAndInterfaces.manufacturer;

import ClassesAndInterfaces.Rentable;
import ClassesAndInterfaces.Saleable;

/**
 *
 * @author Cip
 */
public class Car implements Saleable, Rentable {

    /**
     * @enum enumeration of accepted car colors
     */
    public enum Color {
        WHITE,
        RED,
        YELLOW,
        GREEN,
        GRAY,
        BLACK
    };
    /**
     * Internal hidden fields / attributes
     */
    private Color color;
    private String name;
    private short speed;
    private int salePrice = -1;
    private int dailyRentPrice = -1;
    
    
    /**
     * Constructors
     */
    public Car() {
        name = "Default car name";
        speed = 90;
    }

    /**
     *
     * @param carName
     * @param carSpeed
     * @param carColor
     */
    public Car(String carName, short carSpeed, Color carColor) {
        setName(carName);
        setSpeed(carSpeed);
        setColor(carColor);
    }

    /*get-ers and set-ers*/

    /**
     *
     * @return
     */

    public String getName() {
        return (name);
    }

    /**
     *
     * @return
     */
    public Color getColor() {
        return (color);
    }

    /**
     *
     * @return the car's current speed
     */
    public short getSpeed() {
        return (speed);
    }

    private void setName(String newName) {
        name = newName;
    }

    private void setColor(Color newColor) {
        color = newColor;
    }

    private void setSpeed(short newSpeed) {
        speed = newSpeed;
    }

    /**
     * The method increase actual speed of Car until final speed specified.
     *
     * @param newSpeed is new speed
     */
    public void increaseSpeed(short newSpeed) {
        if (newSpeed > speed) {
            speed = newSpeed;
        } else if (newSpeed < speed) {
            decreaseSpeed(newSpeed);
        }
    }

    /**
     * The method decrease actual speed of Car until final speed specified.
     *
     * @param newSpeed is new speed
     */
    public void decreaseSpeed(short newSpeed) {
        if (newSpeed < speed) {
            speed = newSpeed;
        } else if (newSpeed < speed) {
            increaseSpeed(newSpeed);
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
        if(salePrice > 0) {
            return salePrice;
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
        if(dailyRentPrice > 0) {
            return dailyRentPrice;
        } else {
            return -1;
        }
    }

    // method used by the manufacturer to set the Sale Price
    void setSalePrice(int price) {
        this.salePrice = price;
    }
    
    // method used by the manufacturer to set the Daily Rent Price
    void setDailyRentPrice(int price) {
        this.dailyRentPrice = price;
    }

}
