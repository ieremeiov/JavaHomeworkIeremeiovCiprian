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
    public static String source = "xx109211988345346999xxx113202002999989xxxx"
                            + "213212988345346999xxx1210919881111119999   x sdf 2111120023456346";

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
        System.out.println("Source is: " + source);

        Matcher matcher = pattern.matcher(source);
        boolean found = false;

        while (matcher.find()) {

            String date = matcher.group().substring(0, 9);

            String result;
            result = String.format("I found text \"%s\" starting at index %d until %d.",
                    matcher.group(), matcher.start(), matcher.end());
            System.out.println(result);
            found = true;

            // Testing
            char firstChar = date.charAt(0);
            
            int sex = Integer.parseInt(String.valueOf(firstChar));
            int month = Integer.parseInt(date.substring(1, 3));
            int day = Integer.parseInt(date.substring(3, 5));
            int year = Integer.parseInt(date.substring(5, 9));
            
            // regex makes sure it's 1 or 2
            System.out.println((sex == 1) ? "MALE" : "FEMALE");
            System.out.println("Month is: " + month);
            System.out.println("Day is: " + day);
            System.out.println("Year is: " + year);
            
            
            DateValidator validator = DateValidator.create();
            
            if (validator.isValidDate(date)) {
                System.out.println("--------------------------------------");
                System.out.println("Valid CNP: " + matcher.group());
                System.out.println("--------------------------------------");
            }
            // Finished Testing
        }
        if (!found) {
            System.out.println("No match found!");
        }

    }

    
    public static String CNPregex() {
        String CNP = "[12](0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])(19|20)\\d\\d[0-9]{6}";    
        return CNP;
    }

    
}
