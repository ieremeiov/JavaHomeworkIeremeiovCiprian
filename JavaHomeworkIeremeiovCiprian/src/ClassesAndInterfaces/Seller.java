/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesAndInterfaces;

import ClassesAndInterfaces.manufacturer.Manufacturer;

/**
 *
 * @author Cip
 */
public interface Seller {
    
    public static final boolean IS_SELLER = true;
    
    public void setSalePrice(Manufacturer manufacturer, Saleable car, int price);

    
}
