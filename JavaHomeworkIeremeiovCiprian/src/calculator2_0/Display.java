/*
 * Class that handles the displaying of requests and also the result of the whole calculation on the screen.
 */
package calculator2_0;

/**
 *
 * @author Cip
 */
public class Display {
    
    /**
     * Displays the message that you've entered as a parameter.
     * @param message The message that you want to print on the screen.
     */
    public void displayMessage(String message) {
        System.out.print("\r " + message);
    }
    
    /**
     * Displays the whole formula, without the result.
     * @param button The string of buttons that you have given as input.
     */
    public void displayAll(Button button[]) {
        System.out.print("\r "+ button[0].getButtonPressed() + " " + button[1].getButtonPressed() + " " + button[2].getButtonPressed() + " " + button[3].getButtonPressed() + " ");
    }
    
    /**
     * Displays the result of your operations.
     * @param calculation The Calculation object whose result you want to display.
     */
    public void displayResult(Calculation calculation) {
        System.out.print(calculation.getStringResult());
    }
    
    
}
