public class StringReverser {

    public static String reverseInPlace(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }

        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;
        }

        return new String(charArray);
    }

    public static void main(String[] args) {
        String original = "Gemini";
        String reversed = reverseInPlace(original);
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }
}
