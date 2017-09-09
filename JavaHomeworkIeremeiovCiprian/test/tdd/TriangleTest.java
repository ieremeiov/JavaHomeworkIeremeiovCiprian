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
public class TriangleTest {

    public TriangleTest() {
    }

    /**
     * Test of getDefinition method, of class Triangle.
     */
    @Test
    public void testGetDefinition() {
        Definable triunghi = new Triangle();
        String actualDefinition = triunghi.getDefinition();
        String expectedDefinition = "Two dimensional geometric shape defined by three liens and three angles.";
        assertEquals(expectedDefinition, actualDefinition);
    }

    /**
     * Test of getDefinition method, of class Triangle.
     */
    @Test
    public void testGetDefinition2() {
        Definable triunghi = new Triangle();
        String actualDefinition = triunghi.getDefinition();
        String expectedDefinition = "anything else";
        assertFalse(expectedDefinition.equals(actualDefinition));
    }

}
