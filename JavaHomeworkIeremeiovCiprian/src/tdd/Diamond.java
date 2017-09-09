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
public class Diamond extends Quadrilateral implements Definable {
    
    private String definition;

    
    @Override
    public String getDefinition() {
        definition = super.getDefinition() + "of equal length forming two opposite acute angles and two opposite obtuse angles.";
        return definition;
    }
    
    
}
