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
public class DreptunghiTest {

    public DreptunghiTest() {
    }

    /**
     * Test of getDefinition method, of class Dreptunghi.
     */
    @Test
    public void testGetDefinition() {
        Definibila dreptunghi = new Dreptunghi();
        String actualDefinition = dreptunghi.getDefinition();
        String expectedDefinition = "Figura geometrica plana patrulaterul cu toate unghiurile drepte";
        assertEquals(expectedDefinition, actualDefinition);
    }

}
