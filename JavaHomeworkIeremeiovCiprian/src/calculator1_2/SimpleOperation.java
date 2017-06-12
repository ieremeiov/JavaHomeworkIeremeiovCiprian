/*
 *  This is the Operation class. 
 *  It can test the operation.
 *  If the test has passed, it can make the necessary computations.
 *
 */
package calculator1_2;

/**
 *
 * @author Cip
 */
public class SimpleOperation {
    
    private final char[] operationSymbol = {'+', '-', '*', '/'};
    private final String[] operationToString = {"addition", "substraction", "multiplication", "division"};
    
    private char operation;
    private int operationIndex;
    private boolean knownOperation = true;
    private char unknownOperation = ' ';
    
    /**
     *
     * @param requestedOperation The symbol for the operation to be verified and performed.
     */
    public SimpleOperation(char requestedOperation) {
        
        if(verifyOperation(requestedOperation)) {
                this.operation = operationSymbol[operationIndex];
            } else {
                knownOperation = false;
                unknownOperation = requestedOperation;
                System.out.println("Warning! Invalid operation!");
            }
    }
    
    private boolean verifyOperation(char requestedOperation) {
        boolean flag = true;
        for(int i = 0; i < operationSymbol.length; i++) {
            if(requestedOperation == operationSymbol[i]) {
                operationIndex = i;
                return true;
            } else {
                
                flag = false;
            }
        }
        return flag;
    }
    
    /**
     *
     * @param numbers The array of numbers you wish to add.
     * @return Result of addition operation.
     */
    public double addition(double[] numbers) {
        double result = 0;
        for(int i = 0; i < numbers.length; i++) {
            result += numbers[i];
        }
        return result;
    }
    
    /**
     *
     * @return The symbol of your requested operation.
     */
    public char getOperationSymbol() {
        return operationSymbol[this.operationIndex];
    }
    
    /**
     *
     * @return True - if the operation is found in the list of known operations.
     */
    public boolean getKnownOperation() {
        return knownOperation;
    }
    
    /**
     *
     * @return The operation index relative to the array of possible operations.
     *  {'+', '-', '*', '/'}
     */
    public int getOperationIndex() {
        return operationIndex;
    }
    
    /**
     *
     * @return The symbol of the invalid operation, if it is the case. Otherwise, it returns an empty char ' '.
     * 
     */
    public int getUnknownOperation() {
        return unknownOperation;
    }
    
    /**
     *
     * @return The name of your operation, as a String.
     */
    public String getOperationToString() {
        return this.operationToString[this.getOperationIndex()];
    }
}
