/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesAndInterfaces.Interfaces;

import ClassesAndInterfaces.manufacturer.Manufacturer;

/**
 *
 * @author Cip
 */
public interface Renter {
    
    /**
     *
     */
    public static final boolean IS_RENTER = true;
    
    /**
     *
     * @param manufacturer
     * @param car
     * @param price
     */
    public void setDailyRentPrice(Manufacturer manufacturer, Rentable car, int price);
}
