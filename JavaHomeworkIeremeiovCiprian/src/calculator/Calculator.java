/*
 *  Calculator care stie doar adunare 
 */
package calculator;

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
        
        double[] numere = new double[NUMERE];
        char operatie;
        
        
            //CalculatorIeftin calculator = new CalculatorIeftin(); // default Constructor test
        
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Baga primul numar");
        numere[0] = scanner.nextDouble();
        //calculator.setNumarul(1, numere[0]); // default Constructor test
        System.out.println("Ai bagat " + numere[0]);
        
        
        System.out.println("Ce vrei sa-i faci?");
        System.out.println("Pentru adunare: +\n Pentru scadere: -\n"
                       + "Pentru inmultire: *\nPentru impartire: /");
        operatie = scanner.next().charAt(0);
        //calculator.setOperatie(operatie); // default Constructor test
        
        
        System.out.println("Mai baga unu");
        numere[1] = scanner.nextDouble();
        // calculator.setNumarul(2, numere[1] ); // default Constructor test
        System.out.println("Ai bagat " + numere[1]);
            
            CalculatorIeftin calculator = new CalculatorIeftin(numere, operatie); // Constructor(double[], char);
            calculator.calculeaza();
      
        calculator.printResult();
        
        
    }
    
}
