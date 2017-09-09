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
public class CircleTest {
    
    public CircleTest() {
    }

    /**
     * Test of getDefinition method, of class Circle.
     */
    @Test
    public void testGetDefinition() {
        Definable cerc = new Circle();
        String actualDefinition = cerc.getDefinition();
        String expectedDefinition = "Two dimensional geometric shape defined by a "
                + "boundary (the circumference) consisting of points equidistant from a fixed point (the centre).";
        assertEquals(expectedDefinition, actualDefinition);
    }
    
     /**
     * Test of getDefinition method, of class Circle.
     */
    @Test
    public void testGetDefinition2() {
        Definable cerc = new Circle();
        String actualDefinition = cerc.getDefinition();
        String expectedDefinition = "anything else";
        assertFalse(expectedDefinition.equals(actualDefinition));
    }
    
}
