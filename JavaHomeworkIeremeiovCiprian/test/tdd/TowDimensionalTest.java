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
public class TowDimensionalTest {

    public TowDimensionalTest() {
    }

    /**
     * Test of getDefinition method, of class TwoDimensional.
     */
    @Test
    public void testGetDefinition() {
        Definable plana = new TwoDimensional();
        String actualDefinition = plana.getDefinition();
        String expectedDefinition = "Two dimensional geometric shape ";
        assertEquals(expectedDefinition, actualDefinition);
    }

}
