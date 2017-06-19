/*
 *  
 */
package calculator2_0;

import java.util.Scanner;

/**
 * Class that handles your input when you are requested for the elements of your chosen operation a.k.a the Buttons you "Press"
 * @author Cip
 */
public class Button {
    
    private String buttonPressed;
    private boolean confirmed = true;
    private boolean exit = false;
    
    private Scanner scanner = new Scanner(System.in);
    
    /**
     * Sets the next number in the Buttons array.
     * @param frame The Frame object that you are using for a set of basic operations.
     * @param index The index of the current input that you need to set in the array of Buttons.
     */
    public void pressNumber(Frame frame, int index) {
        frame.getButton()[index].setButtonPressed(this.getScanner().next());
    }
    
    /**
     * Sets the operation in the Buttons array.
     * @param frame The Frame object that you are using for a set of basic operations.
     * @param index The index of the current input that you need to set in the array of Buttons.
     */
    public void pressOperation(Frame frame, int index) {
        frame.getButton()[index].setButtonPressed(this.getScanner().next());
    }
    
    /**
     * Sets the '=' character in the Buttons array. This is Required in order to be able to see the final result.
     * @param frame The Frame object that you are using for a set of basic operations.
     * @param index The index of the current input that you need to set in the array of Buttons.
     */
    public void compute(Frame frame, int index) {
        frame.getButton()[index].setButtonPressed(this.getScanner().next());
        if(!frame.getButton()[index].getButtonPressed().equals("=")) {
            confirmed = false;
        }
    }
   
    /**
     * @return the scanner
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * @param scanner the scanner to set
     */
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * @return the buttonPressed
     */
    public String getButtonPressed() {
        return buttonPressed;
    }

    /**
     * @param buttonPressed the buttonPressed to set
     */
    public void setButtonPressed(String buttonPressed) {
            this.buttonPressed = buttonPressed;
    }

    /**
     *  
     * @return true if the character '=' was inserted when requested.
     */
    public boolean isConfirmed() {
        return confirmed;
    }

    
}
