import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * This class demonstrates how to generate random strings and
 * shuffle the characters of an existing string.
 */
public class StringRandomizer {

    // A reusable Random object.
    // Using SecureRandom is preferred for security-sensitive applications.
    private static final Random random = new Random();

    // The set of characters to use for generating a standard random string
    private static final String ALPHANUMERIC_CHARS = 
        "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * Generates a random string of a specified length from a given set of characters.
     *
     * @param length  The desired length of the random string.
     * @param charSet The string containing all possible characters to use.
     * @return A new, randomly generated string.
     */
    public static String generateRandomString(int length, String charSet) {
        if (length <= 0) {
            return ""; // Handle edge case
        }
        
        // Use default set if none is provided
        if (charSet == null || charSet.isEmpty()) {
            charSet = ALPHANUMERIC_CHARS;
        }

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            // 1. Get a random index from 0 to charSet.length() - 1
            int randomIndex = random.nextInt(charSet.length());
            
            // 2. Get the character at that index
            char randomChar = charSet.charAt(randomIndex);
            
            // 3. Append it to the string builder
            sb.append(randomChar);
        }

        return sb.toString();
    }

    /**
     * Shuffles the characters of a given string into a new random order.
     *
     * @param input The string to shuffle.
     * @return A new string with the same characters as the input, but in a random order.
     */
    public static String shuffleString(String input) {
        if (input == null || input.isEmpty()) {
            return input; // Handle edge case
        }

        // 1. Convert the string to a List of Characters.
        //    We must do this because strings are immutable (cannot be changed).
        List<Character> characters = new ArrayList<>();
        for (char c : input.toCharArray()) {
            characters.add(c);
        }

        // 2. Use the built-in Collections.shuffle() to randomize the list
        Collections.shuffle(characters, random);

        // 3. Rebuild the string from the shuffled list
        StringBuilder sb = new StringBuilder(characters.size());
        for (Character c : characters) {
            sb.append(c);
        }

        return sb.toString();
    }

    /**
     * Main method to demonstrate the functions.
     */
    public static void main(String[] args) {
        
        // --- 1. Generate Random Strings ---
        System.out.println("--- Generating Random Strings ---");
        
        // Generate a 10-character string using the default alphanumeric set
        String randStr1 = generateRandomString(10, null);
        System.out.println("Random Alphanumeric (10): " + randStr1);

        // Generate a 5-character string using only numbers
        String numberSet = "0123456789";
        String randStr2 = generateRandomString(5, numberSet);
        System.out.println("Random Numeric (5):     " + randStr2);

        // Generate a 7-character string using only lowercase letters
        String lowercaseSet = "abcdefghijklmnopqrstuvwxyz";
        String randStr3 = generateRandomString(7, lowercaseSet);
        System.out.println("Random Lowercase (7):   " + randStr3);

        
        // --- 2. Shuffle a Given String ---
        System.out.println("\n--- Shuffling a Given String ---");
        
        String originalString = "HelloJava";
        System.out.println("Original String:  " + originalString);
        
        String shuffledString = shuffleString(originalString);
        System.out.println("Shuffled String: " + shuffledString);
        
        // Running it again will likely produce a different result
        System.out.println("Shuffled Again:  " + shuffleString(originalString));
    }
}
