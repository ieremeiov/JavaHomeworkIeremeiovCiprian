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
public class RombTest {

    public RombTest() {
    }

    /**
     * Test of getDefinition method, of class Romb.
     */
    @Test
    public void testGetDefinition() {
        Definibila romb = new Romb();
        String actualDefinition = romb.getDefinition();
        String expectedDefinition = "Figura geometrica plana patrulaterul cu laturile opuse paralele si congruente";
        assertEquals(expectedDefinition, actualDefinition);
    }

}
