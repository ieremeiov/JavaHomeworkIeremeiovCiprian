/*
 * Pattern finding
 */
package regex;



/**
 *
 * @author Cip
 */
public class Regex {
    // MMDDYYYY
    // MM: 09 / DD: 21  / YYYY: 1988
    private static String source1 = "2xvalid10921198811111211112002123456" // both valid
            + "invalid11320200211111xxxx" // invalid month 13
            + "invalid213212988111111" // invalid year 2988
            + "invalid12109198811111 " // invalid format DDMMYYYY
            + "2xoverlapped 2111120021092119881111"; // intersected
    
    private static String source2 = " 21111200210921198811112222overlapped"; // 2 x CNP intersected

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Scanner scannerRegex = new Scanner(System.in);
        //System.out.println("Insert regex or pattern to be searched: ");
        //String regex = scannerRegex.next();
        
        //Scanner scannerSourceString = new Scanner(System.in);
        //System.out.println("Insert source string: ");
        //String source = scannerSourceString.next();
        
        System.out.println("############################");
        System.out.println("### SEARCHING IN SOURCE1 ...");
        System.out.println("############################");
        
        CNPfinder cnpFinder1 = new CNPfinder(CNPfinder.CNPregex(), source1, false, false);
        cnpFinder1.find();
        
        System.out.println("############################");
        System.out.println("### SEARCHING IN SOURCE2 ...");
        System.out.println("############################");
        
        CNPfinder cnpFinder2 = new CNPfinder(CNPfinder.CNPregex(), source2, true, true);
        cnpFinder2.find();
        

    }
    
}