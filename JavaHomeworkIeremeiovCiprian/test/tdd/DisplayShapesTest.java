/*
 * 
 */
package tdd;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static tdd.DisplayShapes.definitions;

/**
 *
 * @author Cip
 */
public class DisplayShapesTest {

    public static String[] definitiiExpected = null;

    public DisplayShapesTest() {
        // definitiiExpected = new String[4];
    }

    @Before
    public void setUp() {

        definitiiExpected = new String[4];
        definitiiExpected[0] = "Two dimensional geometric shape defined by 4 equal sides and 4 right angles.";
        definitiiExpected[1] = "Two dimensional geometric shape defined by a part of a line that is bounded"
                + " by two distinct end points, and contains every point on the line between its endpoints.";
        definitiiExpected[2] = "Two dimensional geometric shape defined by 4 sides of equal length"
                + " forming two opposite acute angles and two opposite obtuse angles.";
        definitiiExpected[3] = "Two dimensional geometric shape defined by a boundary (the circumference) "
                + "consisting of points equidistant from a fixed point (the centre).";

        Definable segment = new LineSegment();
        Definable diamond = new Diamond();
        Definable square = new Square();
        Definable circle = new Circle();

        definitions.put(square, square.getDefinition());
        definitions.put(segment, segment.getDefinition());
        definitions.put(diamond, diamond.getDefinition());
        definitions.put(new Circle(), circle.getDefinition());

    }

    /**
     * Test of setDefinitionsArray() method, of class DisplayShapes.
     */
    @Test
    public void testsetDefinitionsArray() {

        String[] definitiiActual;
        int size = definitions.values().size();

        definitiiActual = new String[size];

        DisplayShapes.setDefinitionsArray(definitiiActual);

        assertArrayEquals(definitiiExpected, definitiiActual);
    }

}
