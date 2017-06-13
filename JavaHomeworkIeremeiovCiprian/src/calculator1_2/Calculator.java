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
    
    public static final int HOW_MANY_NUMBERS = 2; // We can only compute two numbers

    /**
     * @param args We won't use the command line arguments yet.
     */
    public static void main(String[] args) {
        
        NewCalculator calculator = new NewCalculator(Calculator.HOW_MANY_NUMBERS);
        calculator.useCalculator();
    }
    
}
