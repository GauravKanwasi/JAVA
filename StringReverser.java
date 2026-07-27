import java.util.Scanner;

public final class StringReverser {

    private StringReverser() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static String reverse(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null.");
        }

        if (str.length() < 2) {
            return str;
        }

        int[] codePoints = str.codePoints().toArray();

        for (int left = 0, right = codePoints.length - 1; left < right; left++, right--) {
            int temp = codePoints[left];
            codePoints[left] = codePoints[right];
            codePoints[right] = temp;
        }

        return new String(codePoints, 0, codePoints.length);
    }

    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }

        return str.equals(reverse(str));
    }

    public static void displayResult(String input) {
        System.out.println("Original  : " + input);
        System.out.println("Reversed  : " + reverse(input));
        System.out.println("Palindrome: " + (isPalindrome(input) ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        displayResult(input);

        scanner.close();
    }
}
