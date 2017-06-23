/*
 *   ComputerOOP 2.0 can perform basic operations on Integers. You can add, substract, multiply and divide numbers. 
 *   It assumes you input the right numbers (as Integers) in the right order and press '=' at the end. It will output a result with a precision of 2 digits.
 *
 */
package calculator2_0;

/**
 *  
 * @author Cip
 */
public class ComputerOOP {
    
    /**
     * you can turn off the Messages by manually changing the displayMessage parameter to 'false'.
     * @param args Does not take any arguments.
     */
    public static void main(String[] args) {
        
        boolean displayMessage = true;
        
        
        Calculator calculator = new Calculator();
        Calculator.setMessageOn(displayMessage);
        calculator.turnOn();
        
    }
    
}
