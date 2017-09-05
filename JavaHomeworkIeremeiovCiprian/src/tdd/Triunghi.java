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
public class Triunghi extends Plana implements Definibila {
    
    private String definition;

    
    @Override
    public String getDefinition() {
        definition = super.getDefinition() + "data de reuniunea segmentelor inchise determinate de ele ";
        return definition;
    }
    
}
