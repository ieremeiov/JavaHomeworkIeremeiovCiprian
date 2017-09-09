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
public class LineSegmentTest {

    public LineSegmentTest() {
    }

    /**
     * Test of getDefinition method, of class LineSegment.
     */
    @Test
    public void testGetDefinition() {
        Definable segment = new LineSegment();
        String actualDefinition = segment.getDefinition();
        String expectedDefinition = "Two dimensional geometric shape defined by a part of a line that is bounded"
                + " by two distinct end points, and contains every point on the line between its endpoints.";
        assertEquals(expectedDefinition, actualDefinition);
    }

    /**
     * Test of getDefinition method, of class LineSegment.
     */
    @Test
    public void testGetDefinition2() {
        Definable segment = new LineSegment();
        String actualDefinition = segment.getDefinition();
        String expectedDefinition = "anything else";
        assertFalse(expectedDefinition.equals(actualDefinition));
    }

}
