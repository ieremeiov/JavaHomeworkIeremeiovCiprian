/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex;

import java.text.ParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            + "1xvalid1xnotfound 2111120021092119881111"; // intersected
    public static String source2 = " 21111200210921198811112222xxxx"; // 2 x CNP intersected

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Scanner scannerRegex = new Scanner(System.in);
        //System.out.println("Insert regex or pattern to be searched: ");
        //String regex = scannerRegex.next();
        String regex = CNPregex();

        Pattern pattern = Pattern.compile(regex);

        //Scanner scannerSourceString = new Scanner(System.in);
        //System.out.println("Insert source string: ");
        //String source = scannerSourceString.next();
        System.out.println("Regex is: " + regex);
        System.out.println("Source is: " + source2);

        Matcher matcher = pattern.matcher(source2);
        boolean found = false;
        
        int start = 1;
        
        while (matcher.find(start)) {

            String date = matcher.group().substring(0, 9);

            String result;
            result = String.format("I found text \"%s\" starting at index %d until %d.",
                    matcher.group(), matcher.start(), matcher.end());
            System.out.println(result);
            found = true;
            
            DateValidator validator = DateValidator.create();
            
            if (validator.isValidDate(date)) {
                System.out.println("--------------------------------------");
                System.out.println("Valid CNP: " + matcher.group());
                System.out.println("--------------------------------------");
            }
            // Finished Testing
            start = matcher.start() + 1; // index for the next search
        }
        if (!found) {
            System.out.println("No match found!");
        }

    }

    
        public static String CNPregex() {
        String CNP = "([12](0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])(19|20)\\d{6})";    
        return CNP;
    }

}