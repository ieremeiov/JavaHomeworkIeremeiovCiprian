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
public class RectangleTest {

    public RectangleTest() {
    }

    /**
     * Test of getDefinition method, of class Rectangle.
     */
    @Test
    public void testGetDefinition() {
        Definable dreptunghi = new Rectangle();
        String actualDefinition = dreptunghi.getDefinition();
        String expectedDefinition = "Two dimensional geometric shape defined by 4 sides and 4 right angles.";
        assertEquals(expectedDefinition, actualDefinition);
    }

    /**
     * Test of getDefinition method, of class Rectangle.
     */
    @Test
    public void testGetDefinition2() {
        Definable dreptunghi = new Rectangle();
        String actualDefinition = dreptunghi.getDefinition();
        String expectedDefinition = "anything else";
        assertFalse(expectedDefinition.equals(actualDefinition));
    }

}
