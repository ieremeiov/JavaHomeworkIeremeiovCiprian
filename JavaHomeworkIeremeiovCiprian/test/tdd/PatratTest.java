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
public class PatratTest {

    public PatratTest() {
    }

    /**
     * Test of getDefinition method, of class Patrat.
     */
    @Test
    public void testGetDefinition() {
        Definibila patrat = new Patrat();
        String actualDefinition = patrat.getDefinition();
        String expectedDefinition = "Figura geometrica plana patrulaterul care are toate laturile egale si toate unghiurile drepte. ";
        assertEquals(expectedDefinition, actualDefinition);
    }

}
