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
public class SegmentDeDreaptaTest {

    public SegmentDeDreaptaTest() {
    }

    /**
     * Test of getDefinition method, of class SegmentDeDreapta.
     */
    @Test
    public void testGetDefinition() {
        Definibila segment = new SegmentDeDreapta();
        String actualDefinition = segment.getDefinition();
        String expectedDefinition = "Figura geometrica plana determinata de 2 puncte numite capetele segmentului ";
        assertEquals(expectedDefinition, actualDefinition);
    }

}
