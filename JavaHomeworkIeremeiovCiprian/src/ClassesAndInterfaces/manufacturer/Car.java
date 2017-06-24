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
        WHITE, RED, YELLOW, GREEN, GRAY, BLACK
    };
    /**
     * Internal hidden fields / attributes
     */
    private Color color;
    private String name;
    private short speed;
    private int salePrice;
    private int dailyRentPrice;
    
    
    /**
     * Constructors
     */
    public Car() {
        name = "Default car name";
        speed = 90;
    }

    public Car(String carName, short carSpeed, Color carColor) {
        setName(carName);
        setSpeed(carSpeed);
        setColor(carColor);
    }

    /*get-ers and set-ers*/
    public String getName() {
        return (name);
    }

    public Color getColor() {
        return (color);
    }

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
        return salePrice;
    }

    /**
     * Abstract method defined in Rentable interface implemented by class car is
     * implemented here.
     *
     * @override Rentable.getDailyRentPrice() method
     */
    @Override
    public int getDailyRentPrice() {
        return dailyRentPrice;
    }

    
    void setSalePrice(int price) {
        this.salePrice = price;
    }
    
    void setDailyRentPrice(int price) {
        this.dailyRentPrice = price;
    }

}
