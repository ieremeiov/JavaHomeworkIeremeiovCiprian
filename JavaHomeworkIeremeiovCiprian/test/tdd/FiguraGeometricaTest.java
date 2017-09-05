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
public class FiguraGeometricaTest {

    public FiguraGeometricaTest() {
    }

    /**
     * Test of getDefinition method, of class FiguraGeometrica.
     */
    @Test
    public void testGetDefinition() {
        Definibila figuraGeometirca = new FiguraGeometrica();
        String actualDefinition = figuraGeometirca.getDefinition();
        String expectedDefinition = "Figura geometrica ";
        assertEquals(expectedDefinition, actualDefinition);
    }

}
