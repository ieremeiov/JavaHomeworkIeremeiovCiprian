/*
 *  Class that controls the input to the Calculator and sets an array of buttons based on your input.
 */
package calculator2_0;

/**
 *
 * @author Cip
 */
public class Frame {
    
    private final Button button[] = new Button[4];
    private final Display display = new Display();
    private int index = 0;
    
    /**
     *  Method that asks for the first/next integer.
     */
    public void requestNumber() {
        if(index == 0) {
            this.display.displayMessage("Insert the first number: ");
        }
        if(index == 2) {
            this.display.displayMessage("Insert the second number: ");
        }
        button[index] = new Button();
        button[index].pressNumber(this, index);
        index++;


    }
    
    /**
     * Method that asks for a character as an operation
     */
    public void requestOperation() {
        this.display.displayMessage("Insert operation ( + , - , * , / ): ");
        button[index] = new Button();
        button[index].pressOperation(this, index);
        index++;

    }
    
    /**
     * Asks for the '=' character so that the program knows you want to see the result.
     */
    public void requestEquals() {
        this.display.displayMessage("Press ' = ' to compute: ");
        button[index] = new Button();
        button[index].pressEquals(this, index);

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
    public Display getDisplay() {
        return display;
    }
    
    
    
    
}
