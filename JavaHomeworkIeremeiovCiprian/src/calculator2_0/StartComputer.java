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
        
        frameRequest(frame);
        
        // if '=' is pressed
        if (frame.getButton()[3].isConfirmed() == true) {

            //frame.getButton returns the Button array of the frame object
            frame.getCalculation().calculateOperation(frame.getButton());

            boolean divisionByZero = frame.getCalculation().isDivisionByZero();
            boolean unknownOperation = frame.getCalculation().isUnknownOperation(); 
            
            if (!divisionByZero) {
                if(!unknownOperation) {
                    frame.getDisplay().displayAll(frame.getButton());
                    frame.getDisplay().displayResult(frame.getCalculation());
                }
            }
            if (computeAgain()) {
            //    frame = null;
                turnOn();
            }
        } else {            // if '=' is not pressed
            System.out.println("You didn't press '=' ! Please restart.");
            if(computeAgain()) {
             //   frame = null;
                turnOn();
            }
        }
    }
    
    
    
    
    // asks for numbers, operation and equals sign.
    private void frameRequest(Frame frame) {
        frame.requestNumber();
        frame.display.displayCurrent(frame);
        frame.requestOperation();
        frame.display.displayCurrent(frame);
        frame.requestNumber();
        frame.display.displayCurrent(frame);

        frame.requestConfirmation();
    }
        
    
    // asks the user if he wants to Reset the ComputerOOP
    private boolean computeAgain() {
        Scanner answer = new Scanner(System.in);
        System.out.println("\r\nDo you want to compute again? (y/n)");
        
        char myAnswer = answer.next().toLowerCase().charAt(0);
        
        if(myAnswer == 'y') {
            return true;
        } else {
            System.out.println("Thank You for using my Calculator 2.0");
            return false;
        }
    }
    
     
    
}
