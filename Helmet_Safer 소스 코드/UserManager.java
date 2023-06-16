import java.util.HashMap;

public class UserManager {
    private static HashMap<String, String> userCredentials = new HashMap<>();

    public static HashMap<String, String> getUserCredentials() {
        return userCredentials;
    }
    
    private static String lastPinNumber = null;

    public static String getPinNumber() {
        return lastPinNumber;
    }

    public static void setPinNumber(String pinNumber) {
        lastPinNumber = pinNumber;
    }
    
}