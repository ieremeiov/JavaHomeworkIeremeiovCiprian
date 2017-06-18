/*
 *  This class can Turn On the Calculator.
 */
package calculator2_0;

/**
 *
 * @author Cip
 */
public class StartCalculator {
    
    /**
     * Turns on the calculator, then asks: first number, then operation, then the second number and finally the equals sign. 
     * Press "Enter" after every input.
     */
    public void turnOn() {
        
        Frame frame = new Frame();
        
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
        
        
    }
    
}
