/*
 * 
 */
package calculator2_0;


/**
 * Class that handles the displaying of requests and also the result of the whole calculation on the screen.
 * @author Cip
 */
public class Screen {
    
    /**
     * Displays the message that you've entered as a parameter.
     * @param message The message that you want to print on the screen.
     */
    public void display(String message) {
        System.out.print(message);
    }
    
    /**
     * Displays the whole formula, without the result.
     * @param button The string of buttons that you have given as input.
     */
    public void displayAll(Button button[]) {
        display(">>> Message: " + button[0].getButtonPressed() + " " + button[1].getButtonPressed() + " " + button[2].getButtonPressed() + " " + button[3].getButtonPressed() + " ");
    }
    
    /**
     * Displays the result of your operations, with 2 decimals.
     * @param calculation The DataProcess object whose result you want to display.
     */
    public void displayResult(DataProcess calculation) {
        String result = String.format("%.2f\n", calculation.getResult());
        display(result);
        display(">>> Display: " + result);
    }
    
    /**
     * Sets the display to "0";  
     */
    public static void clear() {
        System.out.println(">>> Display: 0");
    }
    
    /**
     * Sets the display to the last input inserted.
     * @param frame The frame instance whose last button pressed you want to get, in String format.
     */
    public void displayCurrent(PhysicalFrame frame) {
        display(">>> Display: " + frame.currentValue() + "\n");
    }
    
}
