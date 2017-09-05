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
public class PlanaTest {

    public PlanaTest() {
    }

    /**
     * Test of getDefinition method, of class Plana.
     */
    @Test
    public void testGetDefinition() {
        Definibila plana = new Plana();
        String actualDefinition = plana.getDefinition();
        String expectedDefinition = "Figura geometrica plana ";
        assertEquals(expectedDefinition, actualDefinition);
    }

}
