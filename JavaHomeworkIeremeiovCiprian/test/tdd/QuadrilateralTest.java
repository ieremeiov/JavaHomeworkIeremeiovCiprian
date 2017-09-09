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
public class QuadrilateralTest {

    public QuadrilateralTest() {
    }

    /**
     * Test of getDefinition method, of class Quadrilateral.
     */
    @Test
    public void testGetDefinition() {
        Definable patrulater = new Quadrilateral();
        String actualDefinition = patrulater.getDefinition();
        String expectedDefinition = "Two dimensional geometric shape defined by 4 sides ";
        assertEquals(expectedDefinition, actualDefinition);

    }

}
