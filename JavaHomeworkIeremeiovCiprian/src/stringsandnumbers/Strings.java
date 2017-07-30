/*
 * Strings and Numbers
 */
package stringsandnumbers;

/**
 *
 * @author Cip
 */
public class Strings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Question1
        StringBuilder sb = new StringBuilder("Able was I ere I saw Elba.");
        System.out.println("Question1:\n\tsb.capacity(): " + sb.capacity());
        
        
        //Question2
        String hannah = "Did Hannah see bees? Hannah did.";
        System.out.println("Question2:\n\ta. hannah.length() = " + hannah.length());
        System.out.println("\tb. hannah.charAt(12) = " + hannah.charAt(12));
        
        char bCharacter = hannah.charAt(hannah.indexOf("b"));
        System.out.println("\tc. Expression that refers to 'b': "
                           + "hannah.charAt(hannah.indexOf(\"b\")\n\t   Output of expression is: " + bCharacter);
        
        // Question3
        String substring = "Was it a car or a cat I saw?".substring(9, 12);
        System.out.println("Question3:\n\tSubstring is: \"" + substring + "\" the space after \"car\" is not captured\n\t"
                + "The String returned begins at index 9 and ends at index (12-1)");
        System.out.println("\tSubstring's length is: " + substring.length());
        
       // System.out.println("A test from Oracle's Java Tutorials that can be ignored: ");
       // ComputeResult.main(args);
        
       // Question4
       String hi = "Hi, ";
       String mom = "mom.";
       String concat = String.format("%s%s",hi, mom); 
       System.out.println("Question4:\n\tString returned from String.format(\"%s%s\",hi, mom): \n\t\"" + concat + "\"");
       
       // Question5
       String[] name = new String[1];
       name[0] = "Ieremeiov Ciprian Alexandru";
       Question5.main(name);
       
       // Question6
       System.out.println("Question6: \n\tSubclasses of the abstract class <Number>:\n" +
                            "\t<Byte>, <Integer>, <Double>, <Short>, <Float>, <Long>. \n" +
                            "\t<BigDecimal> and <BigInteger> for high precision calculations.\n\t" + 
                            "<AtomicInteger> and <AtomicLong> for multi-threaded applications.");
        
    }
    
}
