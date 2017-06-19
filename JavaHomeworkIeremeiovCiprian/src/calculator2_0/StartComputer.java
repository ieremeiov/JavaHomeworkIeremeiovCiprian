/*
 *  
 */
package calculator2_0;

import java.util.Scanner;

/**
 * This class can Turn On the ComputerOOP.
 * @author Cip
 */
public class StartComputer {
    
    /**
     * Turns on the calculator, then asks: first number, then operation, then the second number and finally the equals sign. 
     * Press "Enter" after every input. When asked if you want to make another computation press 'y' or 'Y' for affirmative; press anything else to close the ComputerOOP.
     */
    public void turnOn() {
        
        Frame frame = new Frame();
        frame.reset();
        
        frame.requestNumber();
        frame.display.displayCurrent(frame);
        frame.requestOperation();
        frame.display.displayCurrent(frame);
        frame.requestNumber();
        frame.display.displayCurrent(frame);

        frame.requestConfirmation();

        Calculation calculation = new Calculation();

        if (frame.getButton()[3].isConfirmed() == true) {

            //frame.getButton returns the Button array of the frame object
            calculation.calculateOperation(frame.getButton());

            boolean canCalculate = calculation.isDivisionByZero() == false && calculation.isUnknownOperation();
            if (!canCalculate) {
                frame.getDisplay().displayAll(frame.getButton());
                frame.getDisplay().displayResult(calculation);
            }
            computeAgain();
        } else {
            System.out.println("You didn't press '=' ! Please restart.");
            computeAgain();
        }
    }
    
    
    // asks the user if he wants to Reset the ComputerOOP
    private void computeAgain() {
        Scanner answer = new Scanner(System.in);
        System.out.println("\r\nDo you want to compute again? (y/n)");
        
        char myAnswer = answer.next().toLowerCase().charAt(0);
        
        if(myAnswer == 'y') {
            turnOn();
        } else {
            System.out.println("Thank You for using my Calculator 2.0");
        }
    }
    
     
    
}
