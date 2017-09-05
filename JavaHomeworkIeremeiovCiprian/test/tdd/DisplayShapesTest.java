/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdd;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static tdd.DisplayShapes.definitii;

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
        definitiiExpected[0] = "Figura geometrica plana patrulaterul care are toate laturile egale si toate unghiurile drepte. ";
        definitiiExpected[1] = "Figura geometrica plana determinata de 2 puncte numite capetele segmentului ";
        definitiiExpected[2] = "Figura geometrica plana patrulaterul cu laturile opuse paralele si congruente";
        definitiiExpected[3] = "Figura geometrica plana formata din multimea tuturor punctelor egal departate de un punct fix";

        Definibila segment = new SegmentDeDreapta();
        Definibila romb = new Romb();
        Definibila patrat = new Patrat();
        Definibila cerc = new Cerc();

        definitii.put(patrat, patrat.getDefinition());
        definitii.put(segment, segment.getDefinition());
        definitii.put(romb, romb.getDefinition());
        definitii.put(new Cerc(), cerc.getDefinition());

        /*
    Figura geometrica plana patrulaterul care are toate laturile egale si toate unghiurile drepte. 
    Figura geometrica plana determinata de 2 puncte numite capetele segmentului 
    Figura geometrica plana patrulaterul cu laturile opuse paralele si congruente
    Figura geometrica plana formata din multimea tuturor punctelor egal departate de un punct fix
         */
    }

    /**
     * Test of main method, of class DisplayShapes.
     */
    @Test
    public void testMain() {

        String[] definitiiActual;
        int size = definitii.values().size();

        definitiiActual = new String[size];

        DisplayShapes.setDefinitiiArray(definitiiActual);

        assertArrayEquals(definitiiExpected, definitiiActual);
    }

}
