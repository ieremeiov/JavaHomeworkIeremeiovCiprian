/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdd;

/**
 *
 * @author Cip
 */
public class Circle extends TwoDimensional implements Definable {
    
    private String definition;
    
    @Override
    public String getDefinition() {
        definition = super.getDefinition() + "defined by a boundary (the circumference) consisting of points equidistant from a fixed point (the centre).";
        return definition;
    }
    
    
    
    
    
}
