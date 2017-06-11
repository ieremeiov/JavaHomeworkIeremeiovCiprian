/*
 *  Calculator care stie doar adunare 
 */
package calculator1_1;

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
        
        
        CalculatorIeftin calculator = new CalculatorIeftin();
        
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nBaga primul numar\n");
        numere[0] = scanner.nextDouble();
        calculator.setNumere(1, numere[0]); 
        System.out.println("Ai bagat " + numere[0]);
        
        
        System.out.println("\nCe vrei sa-i faci?\n");
        System.out.println("Pentru adunare: +\n Pentru scadere: -\n"
                       + "Pentru inmultire: *\nPentru impartire: /\n");
        operatie = scanner.next().charAt(0);
        calculator.setOperatie(operatie); 
        
        
        System.out.println("\nMai baga unu\n");
        numere[1] = scanner.nextDouble();
        calculator.setNumere(2, numere[1] );
        System.out.println("Ai bagat " + numere[1] + "\n");
            
        
        
        calculator.calculeaza();
               
        System.out.println("Operatie verificata: " + calculator.operatieVerificata);
        System.out.println("Am calculat: " + calculator.amCalculat);
        
        
        
    }
    
}
