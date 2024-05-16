package za.ac.cput.util;

import java.util.UUID;
import java.util.regex.Pattern;

public class Helper {
    public static boolean isNullorEmpty(String s){
        if (s == null || s.isEmpty())
            return true;
        return false;
    }
    public static boolean isValidEmail(String email) {
        // Regex pattern for validating email addresses
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.compile(emailRegex).matcher(email).matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Regex pattern for validating a 10-digit phone number
        String phoneRegex = "^\\d{10}$";
        return Pattern.compile(phoneRegex).matcher(phoneNumber).matches();
    }
    public static String generateId(){
        return UUID.randomUUID().toString();
    }
}
