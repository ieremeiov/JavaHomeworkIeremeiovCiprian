/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Cip
 */
public class Regex {

    // MM: 09 / DD: 21  / YYYY: 1988
    public static String source = "xx109211988345346999xxx113202002999989xxxx213212988345346999";

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

            int month = Integer.parseInt(date.substring(1, 3));
            int day = Integer.parseInt(date.substring(3, 5));
            int year = Integer.parseInt(date.substring(5, 9));
            
            System.out.println("Month is: " + month);
            System.out.println("Day is: " + day);
            System.out.println("Year is: " + year);

            if (isValidDate(date)) {
                System.out.println("--------------------------------------");
                System.out.println("Valid CNP: " + matcher.group());
                System.out.println("--------------------------------------");
            }
        }
        if (!found) {
            System.out.println("No match found!");
        }

    }

    //            21091988345345
    //    
    public static String CNPregex() {

        String CNP = "[1-2]\\d{14}";

        return CNP;
    }

    public static boolean isValidDate(String dateString) {
        if (dateString == null || dateString.length() != "SMMddyyyy".length()) {
            return false;
        }

        int year;
        int month;
        int day;
        try {
            month = Integer.parseInt(dateString.substring(1, 3));
            day = Integer.parseInt(dateString.substring(3, 5));
            year = Integer.parseInt(dateString.substring(5, 9));

        } catch (NumberFormatException e) {
            return false;
        }

        // leap years calculation not valid before 1581
        boolean yearOk = (year >= 1581) && (year <= 2017);
        boolean monthOk = (month >= 1) && (month <= 12);
        boolean dayOk = (day >= 1) && (day <= daysInMonth(year, month));

        return (yearOk && monthOk && dayOk);
    }

    private static int daysInMonth(int year, int month) {
        int daysInMonth;
        switch (month) {
            case 1: // fall through
            case 3: // fall through
            case 5: // fall through
            case 7: // fall through
            case 8: // fall through
            case 10: // fall through
            case 12:
                daysInMonth = 31;
                break;
            case 2:
                if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                    daysInMonth = 29;
                } else {
                    daysInMonth = 28;
                }
                break;
            default:
                // returns 30 even for nonexistant months 
                daysInMonth = 30;
        }
        return daysInMonth;
    }

}
