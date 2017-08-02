/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex;



/**
 *
 * @author Cip
 */
public class Regex {
    // MMDDYYYY
    // MM: 09 / DD: 21  / YYYY: 1988
    public static String source1 = "2xvalid10921198811111211112002123456" // all valid
            + "invalid11320200211111xxxx" // invalid month 13
            + "invalid213212988111111" // invalid year 2988
            + "invalid12109198811111 " // invalid format DDMMYYYY
            + "?? 2111120021092119881111"; // intersected
    
    public static String source2 = " 21111200210921198811112222xxxx"; // 2 x CNP intersected

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
        
        CNPfinder cnpFinder = new CNPfinder(CNPfinder.CNPregex(), source1);
        cnpFinder.find();
        

    }
    
}