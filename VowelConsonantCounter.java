import java.util.Scanner;

public class VowelConsonantCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        int vowels = 0;
        int consonants = 0;
        int digits = 0;
        int spaces = 0;
        int specialChars = 0;

        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                char c = Character.toLowerCase(ch);

                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            } else if (Character.isDigit(ch)) {
                digits++;
            } else if (Character.isWhitespace(ch)) {
                spaces++;
            } else {
                specialChars++;
            }
        }

        System.out.println("\n----- Analysis -----");
        System.out.println("Input               : " + input);
        System.out.println("Total Characters    : " + input.length());
        System.out.println("Alphabets           : " + (vowels + consonants));
        System.out.println("Vowels              : " + vowels);
        System.out.println("Consonants          : " + consonants);
        System.out.println("Digits              : " + digits);
        System.out.println("Spaces              : " + spaces);
        System.out.println("Special Characters  : " + specialChars);

        scanner.close();
    }
}
