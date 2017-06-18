/*
 *  
 */
package calculator2_0;

import java.util.Scanner;

/**
 * This class can Turn On the Calculator.
 * @author Cip
 */
public class StartCalculator {
    
    /**
     * Turns on the calculator, then asks: first number, then operation, then the second number and finally the equals sign. 
     * Press "Enter" after every input. When asked if you want to make another computation press 'y' or 'Y' for affirmative; press anything else to close the Calculator.
     */
    public void turnOn() {
        
        Frame frame = new Frame();
        frame.reset();

        
        frame.requestNumber();
        frame.requestOperation();

        frame.requestNumber();
        frame.requestEquals();
        
        Calculation calculation = new Calculation();
        
        calculation.calculateOperation(frame.getButton());
        
        if(calculation.isDivisionByZero() == false && calculation.isUnknownOperation() == false) {
            frame.getDisplay().displayAll(frame.getButton());
            frame.getDisplay().displayResult(calculation);
        }
        
        computeAgain();
    }
    
    
    // asks the user if he wants to Reset the calculator
    private void computeAgain() {
        Scanner answer = new Scanner(System.in);
        System.out.println("\r\nDo you want to compute some more? (y/n)");
        
        char myAnswer = answer.next().toLowerCase().charAt(0);
        
        if(myAnswer == 'y') {
            turnOn();
        } else {
            System.out.println("Thank You for using my Calculator 2.0");
        }
        
    }
}   