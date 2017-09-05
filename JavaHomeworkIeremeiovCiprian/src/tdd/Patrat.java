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
public class Patrat extends Patrulater implements Definibila {
    
    private String definitie;

    
    @Override
    public String getDefinition() {
        definitie = super.getDefinition() + "care are toate laturile egale si toate unghiurile drepte. ";
        return definitie;
    }
    
    
    
}
