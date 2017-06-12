/*
 * Calculator that can only do addition
 *   
 */
package calculator1_2;

import java.util.Scanner;

/**
 * @version 1.2
 * @author Cip
 */
public class NewCalculator {
    
    
    private int numberIndex = 0;
    
    private final double[] NUMBERS = new double[Calculator.HOW_MANY_NUMBERS];
    private SimpleOperation operation;
    private double result;
    private boolean unableToSolveYet = false;
    private boolean unableToSolveEver = false;
    private final int HOW_MANY_NUMBERS;
    
    /**
     *
     * @param howManyNumbers how many numbers can we compute (version 1.2 can only compute 2 numbers)
     */
    public NewCalculator(int howManyNumbers) {
        this.HOW_MANY_NUMBERS = howManyNumbers;
        printMenu();
    }
    
    private void printMenu() {
        System.out.println(" <<< CALCULATOR 1.2 >>>\n");
    }
    
    private void requestNumber() {
        switch (numberIndex) {
            case 0:
                System.out.println("Insert the first number: ");
                break;
            case 1:
                System.out.println("Insert the second number: ");
                break;
            case 2:
                System.out.println("Insert the third number");
                break;
            default:
                System.out.println("Insert the " + (numberIndex+1) + "th number: ");
                break;
        }
    }
    
    private void setNumbers(int index, double[] numbers) {
        this.NUMBERS[index] = numbers[index];
    }
    
    private void printComputation() {
        if(operation.getKnownOperation()) {
            System.out.print("\nYou wish to perform " + operation.getOperationToString().toUpperCase() + " on the numbers: ");
            for(int i = 0; i < HOW_MANY_NUMBERS; i++) {
                System.out.print("[" + NUMBERS[i] + "] ");
            }
            System.out.println("\n");
        }
    }
    
    private void requestOperation() {
        System.out.println("Pick an operation from the list below: ");
        System.out.println("Addition: '+'\n"
                + "Substraction: '-'\nMultiplication: '*'\n"
                + "Division: '/'");
    }
    
    private void setOperation(char operatie) {
        this.operation = new SimpleOperation(operatie);
    }
    
    private void compute() {
        switch(operation.getOperationSymbol()) {
            case '+':
                result = operation.addition(NUMBERS);
                break;
            case '-':
            case '*':
            case '/':
                System.out.println("Unable to compute! You have installed the free Calculator version. \n"
                        + "If you wish to use the rest of the features please buy the Deluxe Version of Calculator.");
                unableToSolveYet = true;
                break;
            default:
                unableToSolveEver = true;
                break;
        }
    }
    
    private void printResult() {
        if(!unableToSolveEver && operation.getKnownOperation()) {
            if(!unableToSolveYet) {
                System.out.println("Result of " 
                    + operation.getOperationToString() + " is: " +
                    result);
                System.out.println("Never doubt Java!");
            } else {
                System.out.println("Mr Pacurar will soon teach me the "
                    +  operation.getOperationToString() + " operation.");
            }
        } else {
            System.out.println("I've never heard of >>> " +
                  Character.toString ((char) operation.getUnknownOperation()) + " <<< ");
        }
    }
    
    /**
     *  You will be requested 2 numbers one after the other. A list of operations will be printed, from which 
     *  you will have to chose the right symbol for the operation you wish to perform
     *  on the numbers you have just provided.
     */
    public void useCalculator() {
        
        Scanner scanner = new Scanner(System.in);
        
        while(numberIndex < HOW_MANY_NUMBERS) {
            this.requestNumber();
            NUMBERS[numberIndex] = scanner.nextDouble();
            this.setNumbers(numberIndex, NUMBERS);
            numberIndex++;
        }
        
        this.requestOperation();
        
        char requestedOperation = scanner.next().charAt(0);
        this.setOperation(requestedOperation);
        
        this.printComputation();
        
        this.compute();
        
        this.printResult();
        
    }
    
    
}
