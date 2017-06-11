/*
 *  Calculator care stie doar adunare 
 */
package calculator1_2;

import java.util.Scanner;

/**
 *
 * @author Cip
 */
public class Calculator {

    /**
     * @param args daca vom folosi linia de comanda, dar nu este cazul acum.
     */
    public static void main(String[] args) {
        
        int NUMERE = 2; // Stim sa calculam doar 2 numere
        
        
        
        
        CalculatorNou calculator = new CalculatorNou(NUMERE);
        calculator.incepeTreaba();
        
    }
    
}
