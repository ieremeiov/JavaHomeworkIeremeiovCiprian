/*
 *  
 */
package calculator2_0;

/**
 * Class that controls the input to the ComputerOOP and sets an array of buttons based on your input. 
 * A button can somehow represent a whole number, not just one digit. 
 * It represents the physical layer of the computer.
 * @author Cip
 */
public class PhysicalFrame {
    
    private final Button button[] = new Button[4];
    private final Screen display = new Screen();

    private int index;
    
    /**
     *  Method that asks for the first/next integer.
     */
    public void requestNumber() {
        if(index == 0) {
            this.display.display(">>> Message: Insert the first number: ");
        }
        if(index == 2) {
            this.display.display(">>> Message: Insert the second number: ");
        }
        button[index] = new Button();
        button[index].pressNumber(this, index);
        index++;

    }
    
    /**
     * Method that asks for an operation as a character.
     */
    public void requestOperation() {
        this.display.display(">>> Message: Insert operation ( + , - , * , / ): ");
        button[index] = new Button();
        button[index].pressOperation(this, index);
        index++;
    }
    
    /**
     * Asks for the '=' character so that the program knows you want to see the result.
     */
    public void requestConfirmation() {
        this.display.display(">>> Message: Press ' = ' to compute: ");
        button[index] = new Button();
        button[index].compute(this, index);
    }
   
    /**
     *
     * @return An array of Button objects
     */
    public Button[] getButton() {
        return button;
    }

    /**
     *
     * @return A Display object
     */
    public Screen getDisplay() {
        return display;
    }
    
    /**
     * Resets the index for building a new Array of Buttons.
     */
    public void reset() {
        this.index = 0;
        Screen.clear();
    }
    
    /**
     *  
     * @return the last button pressed in String format
     */
    public String currentValue() {
        return this.button[index-1].getButtonPressed();
    }
    
    

    
    
    
}
