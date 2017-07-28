/*
 * Extra test of copied code that can be ignored.
 */
package stringsandnumbers;

/**
 *
 * @author Cip
 */
public class ComputeResult {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
         String original = "software";
        StringBuilder result = new StringBuilder("hi");
        int index = original.indexOf('a');

/*1*/   result.setCharAt(0, original.charAt(0));
        System.out.println("\tOutput 1: " + result);
/*2*/   result.setCharAt(1, original.charAt(original.length()-1));
        System.out.println("\tOutput 2: " + result);
/*3*/   result.insert(1, original.charAt(4));
        System.out.println("\tOutput 3: " + result);
/*4*/   result.append(original.substring(1,4));
        System.out.println("\tOutput 4: " + result);
/*5*/   result.insert(3, (original.substring(index, index+2) + " ")); 
        System.out.println("\tOutput 5: " + result);

        
        
    }
    
}
