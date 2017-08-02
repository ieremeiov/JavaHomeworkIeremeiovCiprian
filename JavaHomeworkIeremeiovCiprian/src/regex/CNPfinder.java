/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static regex.Regex.source2;

/**
 *
 * @author Cip
 */
public class CNPfinder {
    
    private String regex;
    private String source;

    public CNPfinder(String regex, String source) {
        this.regex = regex;
        this.source = source;
    }
    
    public void find() {
        

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        
        System.out.println("Regex is: " + regex);
        System.out.println("Source is: " + source);
        
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
            start = matcher.start() + 2; // index for the next search
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
