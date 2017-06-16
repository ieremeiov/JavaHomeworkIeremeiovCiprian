/*
 * Calculator that can only perform addition. But you're not supposed to know that yet.
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
        printWelcome();
    }
    
    private void printWelcome() {
        
        
        System.out.println("      $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        
        System.out.println("      #  <<< Welcome To CALCULATOR ver1.2 >>>  #");
        
        System.out.println("      $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("");
    }
    
    private void requestNumber() {
        switch (numberIndex) {
            case 0:
                System.out.println("      $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                System.out.println("      @ >>>Insert the first number <<< @ ");
                System.out.println("      $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                break;
            case 1:
                System.out.println("      $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                System.out.println("      @ >>>Insert the second number <<< @ ");
                System.out.println("      $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                break;
            case 2:
                System.out.println("      $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                System.out.println("      @ >>>Insert the third number <<<@");
                System.out.println("      $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                break;
            default:
                System.out.println("      $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                System.out.println("      @ >>>Insert the " + (numberIndex+1) + "th number <<<@ ");
                System.out.println("      $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
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
        System.out.println("@***********************************************@"); 
        System.out.println("@ >>> Pick an operation from the list below <<< @ ");
        System.out.println("@***********************************************@"); 
        System.out.println("\n >>> ADDITION: +\n"
                + " >>> SUBSTRACTION: -\n >>> MULTIPLICATION: *\n"
                + " >>> DIVISION: /");
        
        System.out.println("");
        System.out.println("@*************************************************@");    
        System.out.println("| I will only consider the first character typed. |");
        System.out.println("@*************************************************@");  
        System.out.print("Operation: ");
                
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
                System.out.println("!********** WARNING **********!");
                System.out.println("  >>> UNABLE TO COMPUTE <<<\nYou have installed the free Calculator version. \n"
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
                    + operation.getOperationToString() + " is: >>> [" +
                    result + "] <<<");
                System.out.println("Never doubt Java!");
            } else {
                System.out.println("Mr Pacurar will soon teach me the "
                    +  operation.getOperationToString() + " operation.");
            }
        } else {
            System.out.println("");
                
                System.out.println("      @#########@");
                System.out.println("      $ WARNING $");
                
                System.out.println("@######         ######@");
                System.out.println("#  INVALID OPERATION  #");
                System.out.println("@#####################@");
                System.out.println("");
            System.out.println("I've never heard of >>> " +
                  Character.toString ((char) operation.getUnknownOperation()) + " <<< ");
        }
    }
    
    
    private void computeAgain() {
        numberIndex = 0;
        Scanner answer = new Scanner(System.in);
        System.out.println("\n\n");
        System.out.println("Would you like to calculate some more? y/n");
        char my_answer = answer.next().charAt(0);
        if(my_answer == 'y') {
            this.useCalculator();
        } else {
            System.out.println("");
            System.out.println("|#|#|#|#|#|#|#|#|#|#|#|#|#|#|#|#|#|#|#|#|");
            System.out.println(">>> Thank you for using my Calculator <<<");
            System.out.println("|#|#|#|#|#|#|#|#|#|#|#|#|#|#|#|#|#|#|#|#|");
        }
    }
    
    
    /**
     *  You will be requested 2 numbers one after the other. A list of operations will be printed, from which 
     *  you will have to chose the right symbol for the operation you wish to perform
     *  on the numbers you have just provided.
     */
    public void useCalculator() {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("@**************************************************************************@");      
        System.out.println("| Make sure you insert a real number, otherwise you will get an Exception. |");
        System.out.println("@**************************************************************************@"); 
        
        while(numberIndex < HOW_MANY_NUMBERS) {
            this.requestNumber();
            System.out.print("Number: ");
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
        computeAgain();
        
    }

}