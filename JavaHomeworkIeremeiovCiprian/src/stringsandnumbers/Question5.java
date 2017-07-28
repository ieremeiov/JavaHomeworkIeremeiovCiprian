/*
 *   A program that computes your initials from your full name and displays them.
 */
package stringsandnumbers;

/**
 *
 * @author Cip
 */
public class Question5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        args[0] = "Ieremeiov Ciprian Alexandru";
        String myName = args[0];
        
        String[] nameArray = myName.split(" ");

        StringBuilder initials = new StringBuilder();
        
        for(String name : nameArray) {
            if(Character.isLetter(name.charAt(0))) {
               initials.append(name.charAt(0)); 
            }
        }
        

        System.out.println("Question5:\n\tInitials of \"" + myName + "\" are: " + initials);
        
    }
    
}
