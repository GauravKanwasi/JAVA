import java.security.SecureRandom;
import java.util.Objects;

public final class StringRandomizer {

    private StringRandomizer() {}

    private static final SecureRandom RANDOM = new SecureRandom();

    public static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    public static final String DIGITS = "0123456789";
    public static final String SYMBOLS = "!@#$%^&*()-_=+[]{}<>?/|";
    public static final String ALPHABET = UPPERCASE + LOWERCASE;
    public static final String ALPHANUMERIC = ALPHABET + DIGITS;
    public static final String ALL = ALPHANUMERIC + SYMBOLS;

    public static String randomString(int length) {
        return randomString(length, ALPHANUMERIC);
    }

    public static String randomString(int length, String charset) {
        if (length < 0) {
            throw new IllegalArgumentException("Length cannot be negative.");
        }

        Objects.requireNonNull(charset, "Character set cannot be null.");

        if (charset.isEmpty()) {
            throw new IllegalArgumentException("Character set cannot be empty.");
        }

        char[] result = new char[length];

        for (int i = 0; i < length; i++) {
            result[i] = charset.charAt(RANDOM.nextInt(charset.length()));
        }

        return new String(result);
    }

    public static String shuffle(String input) {
        Objects.requireNonNull(input);

        char[] chars = input.toCharArray();

        for (int i = chars.length - 1; i > 0; i--) {
            int j = RANDOM.nextInt(i + 1);
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        return new String(chars);
    }

    public static String randomPassword(
            int length,
            boolean upper,
            boolean lower,
            boolean digits,
            boolean symbols) {

        StringBuilder pool = new StringBuilder();

        if (upper) pool.append(UPPERCASE);
        if (lower) pool.append(LOWERCASE);
        if (digits) pool.append(DIGITS);
        if (symbols) pool.append(SYMBOLS);

        if (pool.length() == 0) {
            throw new IllegalArgumentException("At least one character category must be selected.");
        }

        return randomString(length, pool.toString());
    }

    public static void main(String[] args) {

        System.out.println("Random Alphanumeric : " + randomString(12));
        System.out.println("Random Lowercase    : " + randomString(10, LOWERCASE));
        System.out.println("Random Numeric      : " + randomString(8, DIGITS));
        System.out.println("Random Symbols      : " + randomString(8, SYMBOLS));

        String text = "HelloJava";

        System.out.println("\nOriginal : " + text);
        System.out.println("Shuffle 1: " + shuffle(text));
        System.out.println("Shuffle 2: " + shuffle(text));

        System.out.println("\nPassword : " +
                randomPassword(16, true, true, true, true));
    }
}
