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
public class PatrulaterTest {

    public PatrulaterTest() {
    }

    /**
     * Test of getDefinition method, of class Patrulater.
     */
    @Test
    public void testGetDefinition() {
        Definibila patrulater = new Patrulater();
        String actualDefinition = patrulater.getDefinition();
        String expectedDefinition = "Figura geometrica plana patrulaterul ";
        assertEquals(expectedDefinition, actualDefinition);

    }

}
