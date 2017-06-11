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
        int index = 0;
        double[] numere = new double[NUMERE];
        char operatie;
        
        
        CalculatorNou calculator = new CalculatorNou();
        
        Scanner scanner = new Scanner(System.in);
        
        while(index < NUMERE) {
            calculator.bagaNumarul();
            numere[index] = scanner.nextDouble();
            calculator.setNumere(index, numere);
            index++;
        }
        
        calculator.printNumere();
        calculator.bagaOperatia();
        
        operatie = scanner.next().charAt(0);
        calculator.setOperatie(operatie);
        
        calculator.efectueazaOperatia();
        calculator.printRezultat();
        
        
    }
    
}
