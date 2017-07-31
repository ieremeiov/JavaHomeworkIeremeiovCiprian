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
public class DateValidator {
    
    
    // Date format is MMDDYYYY
    private DateValidator() {
    }
    
    public static DateValidator create() {
        return new DateValidator();
    }
    
    public boolean isValidDate(String dateString) {
        if (dateString == null || dateString.length() != "SMMddyyyy".length()) {
            return false;
        }
        
        int date;
        
        // regex makes sure exception does not occur anyway
        try {
        date = Integer.parseInt(dateString);
        } catch (NumberFormatException e) {
            return false;
        }
        
        int year = (date % 10000);
        int month = (date % 100000000) / 1000000;
        int day = (date % 1000000) / 10000;
        
        /*
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
        */
        
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
