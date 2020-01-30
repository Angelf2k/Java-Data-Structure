public class ValidPhone {
    /*check valid mobile number ,Only contain 10 digit number
 -Format (xxx) xxx-xxxx, xxx-xxx-xxxx, xxx xxx xxxx, xxx xxx-xxx*/
    public static boolean isValid(String phone) {
        if (phone == null) return false;
        int numberSize = phone.replaceAll("\\D", "").length();

        if (numberSize != 10) return false;
        // Verifying formats by size and start character
        if (phone.length() == 14 && phone.charAt(0) == '(') {
            // Format (xxx) xxx-xxxx
            return phone.charAt(4) == ')' && phone.charAt(5) == ' ' && phone.charAt(9) == '-';
        } else if (phone.length() == 12) {
            // xxx-xxx-xxxx, xxx-xxx xxxx
            if (phone.charAt(3) == '-') {
                return phone.charAt(7) == '-' || phone.charAt(7) == ' ';
            }
            // Format xxx xxx xxxx and xxx xxx-xxxx
            return phone.charAt(3) == ' ' && (phone.charAt(7) == ' ' 	|| phone.charAt(7) == '-');
        }
        return false;
        /*
        -Other way to solve this problem but , it has to import this library
        -import java.util.regex.*;
        public boolean isValidPattern(String phone){
          \d{10} matches 1234567890
          (?:\d{3}-){2}\d{4} matches 123-456-7890
          (\d{3}\) \d{3}-?\d{4} matches (123)456-7890 or (123)4567890

        String pattern = "\\d{10}|(?:\\d{3}-)\\d{2}-\\d{4}|\\d{3}\\-?\\d{3}-?\\d{4}";
        return Pattern.compile(pattern).matcher(phone).matches();
        */
    }

    public static void main(String[] args) {
        System.out.println(isValid("703-425 3245"));
        }
}
