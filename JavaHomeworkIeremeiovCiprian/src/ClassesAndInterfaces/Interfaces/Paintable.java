/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesAndInterfaces.Interfaces;

import ClassesAndInterfaces.carselling.Label;

/**
 *
 * @author Cip
 */
public interface Paintable {
    
    /**
     *
     */
    public static final boolean PAINTABLE = true;
    
    /**
     *
     * @return
     */
    public Label.Color getColor();
    public void getPainted(Label.Color color);

    
}
