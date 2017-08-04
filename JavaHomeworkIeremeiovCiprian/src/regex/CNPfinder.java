/*
 * Class that uses a Pattern and a Matcher to search through a String 
 * and find all valid CNPs specified by a certain Regex and Validated by a certain DateValidator
 * CNPfinder requires: a regex, a source String, 
 * boolean to specify if it needs to find overlapped results and boolean for specifying CNP info or not
 */
package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Cip
 */
public class CNPfinder {

    private final String regex;
    private final String source;
    private final boolean printInfo;
    private final boolean findOverlap;

    /**
     *
     * @param regex the pattern specified for searching
     * @param source the text you want to search in
     * @param findOverlap set to true if you want to find overlapping results /
     * set to false and every search will start from the end of the last one
     * @param info set to true if you want to extract some information from each
     * valid CNP, like male/female and date of birth
     */
    public CNPfinder(String regex, String source, boolean findOverlap, boolean info) {
        this.regex = regex;
        this.source = source;
        this.printInfo = info;
        this.findOverlap = findOverlap;
    }

    public void find() {

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);

        System.out.println("SOURCE: " + source);
        System.out.println("");

        boolean found = false;
        int start = 1;

        while (matcher.find(start)) {

            found = true;
            String date = matcher.group().substring(0, 9);
            DateValidator validator = DateValidator.create();

            if (validator.isValidDate(date)) {
                
                String CNP = matcher.group() + "\n";
                System.out.println("-------------------------");
                System.out.println("@Valid CNP: " + CNP);

                if (printInfo) {
                    printCNPinfo(date);
                }
                // System.out.println("-------------------------");
            }
            if (findOverlap) {
                start = matcher.start() + 1; // index for the next search, so that the matcher can find hidden results (overlapped)
            } else {
                start = matcher.end() + 1; // index for the NEXT search starts at the END of the LAST search
            }
        }

        if (!found) {
            System.out.println("No match found!");

        }

    }

    public static String CNPregex() {
        String CNP = "[12](0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])(19|20)\\d{6}";
        return CNP;
    }

    private void printCNPinfo(String dateString) {

        int year = 0;
        int month = 0;
        int day = 0;
        int sex = 0;

        try {
            sex = Integer.parseInt(dateString.substring(0, 1));
            month = Integer.parseInt(dateString.substring(1, 3));
            day = Integer.parseInt(dateString.substring(3, 5));
            year = Integer.parseInt(dateString.substring(5, 9));

        } catch (NumberFormatException e) {
            System.out.println("Regex is wrong, should not be reached in this homework.");
        }

        // regex makes sure it's 1 or 2
        System.out.println("@CNP INFO processing... ");
        System.out.println((sex == 1) ? "MALE" : "FEMALE");
        System.out.println("Month is: " + month);
        System.out.println("Day is: " + day);
        System.out.println("Year is: " + year);

    }

}
