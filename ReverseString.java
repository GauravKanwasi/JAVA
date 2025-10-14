public class ReverseString {

    public static void main(String[] args) {
        String originalStr = "recursion";
        String reversedStr = reverseRecursive(originalStr);
        
        System.out.println("Original string: " + originalStr);
        System.out.println("Reversed string: " + reversedStr);
    }

    // Recursive function to reverse a string
    public static String reverseRecursive(String str) {
        // Base case: if the string is empty or has only one character, return it
        if (str == null || str.length() <= 1) {
            return str;
        }
        
        // Recursive step: take the first character, reverse the rest of the string,
        // and append the first character to the end.
        return reverseRecursive(str.substring(1)) + str.charAt(0);
    }
}
