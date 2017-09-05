/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdd;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cip
 */
public class CercTest {
    
    public CercTest() {
    }

    /**
     * Test of getDefinition method, of class Cerc.
     */
    @Test
    public void testGetDefinition() {
        Definibila cerc = new Cerc();
        String actualDefinition = cerc.getDefinition();
        String expectedDefinition = "Figura geometrica plana formata din multimea tuturor punctelor egal departate de un punct fix";
        assertEquals(expectedDefinition, actualDefinition);
    }
    
}
