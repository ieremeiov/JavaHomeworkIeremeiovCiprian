/*
 *  AddPlus Calculator version: 1.2
 *  Used to compute simple operations on real numbers.
 */
package calculator1_2;

/**
 *
 * @author Cip
 */
public class Calculator {

    /**
     * @param args We won't use the command line arguments yet.
     */
    public static void main(String[] args) {
        
        int howManyNumbers = 2; // We can only compute two numbers
        
        NewCalculator calculator = new NewCalculator(howManyNumbers);
        calculator.useCalculator();
    }
    
}
