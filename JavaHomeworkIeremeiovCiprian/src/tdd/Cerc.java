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
public class Cerc extends Plana implements Definibila {
    
    private String definition;
    
    @Override
    public String getDefinition() {
        definition = super.getDefinition() + "formata din multimea tuturor punctelor egal departate de un punct fix";
        return definition;
    }
    
    
    
    
    
}
