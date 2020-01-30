import java.util.Scanner;

//Validate Appropriate dates

public class validationDate{

public static void main(String[] args) {

        System.out.println("Type a date:");
        Scanner sc = new Scanner(System.in);
        String inputDate = sc.next(); //"mm/dd/yyyy"

        boolean validDate = true;

        if (inputDate.length() != 10) {
            System.out.println("Your date should have 10 characters only: use the format 'mm/dd/yyyy'");
            validDate = false;
        } else {
            for(int i = 0; i < inputDate.length(); i++) {
            switch(i) {
            // verify that mmddyyyy are numbers
            case 0: case 1:  case 3: case 4: case 6: case 7: case 8: case 9:
                char d = inputDate.charAt(i);
                validDate = (d >= '0' && d <= '9');
                if (!validDate) {
                    System.out.printf("Invalid date, the character at position %d is not a number!", i);
                }
                break;
            case 2: case 5:
                validDate = (inputDate.charAt(i) == '/');
                if (!validDate) {
                    System.out.printf("Invalid date, the character at position %d is not a '/'!", i);
                }//end if
                break;
            }  //end of switch
            if (!validDate) break; // stop for loop
        }// end of for

        if (validDate) {
            int mm = Integer.parseInt(inputDate.substring(0, 2));
            int dd = Integer.parseInt(inputDate.substring(3, 5));
            int yyyy = Integer.parseInt(inputDate.substring(6, 10));

            // mm represents the month (01-12)
            if (mm < 1 || mm > 12) {
                    System.out.printf("Invalid date %d is not a valid month!", mm);
                    validDate = false;
            }

        if (dd <= 0 || dd > 31) {
            System.out.printf("Invalid date, %d is not a valid day of a month!"+" \n", dd);
            validDate = false;
        }


        switch(mm) {
        // verify number of days per month or invalid month
        // April, June, September and November each have 30 days
        case 4: case 6: case 9: case 11:
                if (dd > 30) {
                    System.out.printf("Invalid date, %s should have no more than 30 days", validationDate.getMonth(mm));
                    validDate = false;
                }
                break;
        case 2:
                boolean leapYear = validationDate.isLeapYear(yyyy);
                // February has 28 days, except in leap years when it has 29
                if (leapYear && dd > 29) {
                    System.out.printf("Invalid date, %s should have no more than %d days, "
                    + "since %d is a leap year!", validationDate.getMonth(mm), 29, yyyy);
                     validDate = false;
                } else if (!leapYear && dd > 28) {
                    System.out.printf("Invalid date, %s should have no more than 28 days", validationDate.getMonth(mm));
                    validDate = false;
                 }
                break;

        }//end of switch

        // IF passes all checks, so it is good
        if (validDate) {
            System.out.println("This is a good date");
        }

        }//end of if

        }//end of if

 }//end of main

    public static String getMonth(int mm) {
        switch(mm) {
        case 1: return "January";
        case 2: return "February";
        case 3: return "March";
        case 4: return "April";
        case 5: return "May";
        case 6: return "June";
        case 7: return "July";
        case 8: return "August";
        case 9: return "September";
        case 10: return "October";
        case 11: return "November";
        case 12: return "December";
        }//end of switch
            return "Invalid month";
    }//end of get month

//A leap year is a year that is "evenly divisible by 4 but not by 100,
//unless it is also divisible by 400"
    public static boolean isLeapYear(int yyyy) {
        return yyyy % 4 == 0 && (yyyy % 100 != 0 || yyyy % 400 == 0);
    }// end of isLeapYear

}//end of class