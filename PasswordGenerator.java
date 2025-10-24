import java.security.SecureRandom;

public class PasswordGenerator {

    private static final String CHAR_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPERCASE = CHAR_LOWERCASE.toUpperCase();
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()_+-=[]{}|;:'\",.<>/?";
    
    private static final String PASSWORD_CHARS = CHAR_LOWERCASE + CHAR_UPPERCASE + DIGITS + SPECIAL_CHARS;
    private static final SecureRandom random = new SecureRandom();

    public static String generatePassword(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Password length must be greater than 0");
        }

        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(PASSWORD_CHARS.length());
            password.append(PASSWORD_CHARS.charAt(randomIndex));
        }
        return password.toString();
    }

    public static void main(String[] args) {
        int passwordLength = 16;
        String newPassword = generatePassword(passwordLength);
        System.out.println("Generated Password: " + newPassword);
    }
}
