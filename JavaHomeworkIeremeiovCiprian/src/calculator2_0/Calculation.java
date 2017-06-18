/*
 * 
 */
package calculator2_0;

/**
 * Class that handles the chosen operation.
 * @author Cip
 */
public class Calculation {
    
    private final String[] stringButton = new String[4];
    private Double result;
    private boolean divisionByZero = false;
    private boolean unknownOperation = false;
    
    /**
     * Calculates the result based on the user's input.
     * @param receivedButtons Array of Buttons to be processed.
     */
    public void calculateOperation(Button[] receivedButtons) {
        
        for(int i = 0; i < stringButton.length; i++) {
            stringButton[i] = receivedButtons[i].getButtonPressed();
        }
        
        switch(stringButton[1]) {
            case "+":
                result = add(Integer.parseInt(stringButton[0]), Integer.parseInt(stringButton[2]));
                break;
            case "-":
                result = substract(Integer.parseInt(stringButton[0]), Integer.parseInt(stringButton[2]));
                break;
            case "*":
                result = multiply(Double.parseDouble(stringButton[0]), Double.parseDouble(stringButton[2]));
                break;
            case "/":
                if(Integer.parseInt(stringButton[2]) != 0) {
                    result = divide(Double.parseDouble(stringButton[0]), Double.parseDouble(stringButton[2]));
                } else {
                    System.out.println(" Division by 0 is impossible!");
                    divisionByZero = true;
                }
                break;
            default:
                System.out.println("\r Unknown Operation!");
                unknownOperation = true;
                break;
        }
    }
    
    
    private double add(int number1, int number2) {
        return (double)number1 + number2;
    }
    
    private double substract(int number1, int number2) {
        return add(number1, -number2);
    }
    
    private double multiply(double number1, double number2) {
        return number1 * number2;
    }
    
    private double divide(double number1, double number2) {
        return multiply(number1, 1/number2);
    }
    

    /**
     *
     * @return true if the Calculator is asked to perform division by zero / if Denominator is zero / if the second number is zero.
     */
    public boolean isDivisionByZero() {
        return divisionByZero;
    }

    /**
     *
     * @return true if the character selected for the operation is not in the list: (+, -, *, /)
     */
    public boolean isUnknownOperation() {
        return unknownOperation;
    }

    /**
     *
     * @return An array of Buttons in String format.
     */
    public String[] getStringButton() {
        return stringButton;
    }

    /**
     *
     * @return The final result;
     */
    public Double getResult() {
        return result;
    }
    
}
