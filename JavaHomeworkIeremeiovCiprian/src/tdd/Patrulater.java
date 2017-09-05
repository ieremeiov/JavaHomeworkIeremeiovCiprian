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
public class Patrulater extends Plana implements Definibila {
    
    private String definitie;

    
    @Override
    public String getDefinition() {
        this.definitie = super.getDefinition() + "patrulaterul ";
        return definitie;
    }
    
    
    
}
