/*
 *  
 */
package calculator2_0;

import java.util.Scanner;

/**
 * This class can Turn On the ComputerOOP.
 * @author Cip
 */
public class Calculator {
    
    private static boolean messageOn;

    /**
     * Turns on the calculator, then asks: first number, then operation, then the second number and finally the equals sign. 
     * Press "Enter" after every input. When asked if you want to make another computation press 'y' or 'Y' for affirmative; press anything else to close the ComputerOOP.
     */
    public void turnOn() {
        
        // phisical layer
        PhysicalFrame frame = new PhysicalFrame();
        // logical layer
        DataProcess process = new DataProcess();

        frame.reset();
        frameRequest(frame);
        
        // if '=' is pressed
        if (frame.getButton()[3].isConfirmed() == true) {

            //frame.getButton returns the Button array of the frame object
            process.calculateOperation(frame.getButton());

            boolean divisionByZero = process.isDivisionByZero();
            boolean unknownOperation = process.isUnknownOperation(); 
            
            if (!divisionByZero) {
                if(!unknownOperation) {
                    frame.getDisplay().displayAll(frame.getButton());
                    frame.getDisplay().displayResult(process);
                }
            }
            if (computeAgain(frame)) {
            //    frame = null;
                turnOn();
            }
        } else {            // if '=' is not pressed
            if(Calculator.isMessageOn()) {
                System.out.println(">>> Message: You didn't press '=' ! Please restart.");
            }
            if(computeAgain(frame)) {
             //   frame = null;
                turnOn();
            }
        }
    }
    
    
    /**
     * 
     * Sets the Message display On/Off
     * @param msgOn tells the Calculator to display the messages or not
     * 
     */
    public static void setMessageOn(boolean msgOn) {
        messageOn = msgOn;
    }
    
  
    // asks for numbers, operation and equals sign.
    private void frameRequest(PhysicalFrame frame) {
        frame.requestNumber();
        frame.getDisplay().displayCurrent(frame);
        frame.requestOperation();
        frame.getDisplay().displayCurrent(frame);
        frame.requestNumber();
        frame.getDisplay().displayCurrent(frame);

        frame.requestConfirmation();
    }
        
    
    // asks the user if he wants to Reset the ComputerOOP
    private boolean computeAgain(PhysicalFrame frame) {
        Scanner answer = new Scanner(System.in);
        if(Calculator.isMessageOn()) {
            frame.getDisplay().display("\r\n>>> Message: Do you want to compute again? (y/n)");
        }
        
        char myAnswer = answer.next().toLowerCase().charAt(0);
        
        if(myAnswer == 'y') {
            return true;
        } else {
            if(Calculator.isMessageOn()) {
                frame.getDisplay().display(">>> Message: Thank You for using my Calculator 2.0\n");
            }
            return false;
        }
    }

    /**
     * @return the messageOn
     */
    public static boolean isMessageOn() {
        return messageOn;
    }

     
    
}
