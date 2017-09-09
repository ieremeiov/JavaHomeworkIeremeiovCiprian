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
public class Quadrilateral extends TwoDimensional implements Definable {
    
    private String definition;

    
    @Override
    public String getDefinition() {
        this.definition = super.getDefinition() + "defined by 4 sides ";
        return definition;
    }
    
    
    
}
