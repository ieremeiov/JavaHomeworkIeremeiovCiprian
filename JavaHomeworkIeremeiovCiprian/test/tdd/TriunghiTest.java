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
public class TriunghiTest {

    public TriunghiTest() {
    }

    /**
     * Test of getDefinition method, of class Triunghi.
     */
    @Test
    public void testGetDefinition() {
        Definibila triunghi = new Triunghi();
        String actualDefinition = triunghi.getDefinition();
        String expectedDefinition = "Figura geometrica plana data de reuniunea segmentelor inchise determinate de ele ";
        assertEquals(expectedDefinition, actualDefinition);
    }

}
