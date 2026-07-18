public class VowelCounter {

    private static final String VOWELS = "aeiou";

    public static int countVowels(String str) {
        if (str == null || str.isBlank()) {
            return 0;
        }

        int count = 0;

        for (char ch : str.toLowerCase().toCharArray()) {
            if (VOWELS.indexOf(ch) != -1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String[] testStrings = {
            "Hello World",
            "Programming is Fun",
            "AEIOUaeiou",
            "Rhythm",
            "",
            null
        };

        for (String str : testStrings) {
            System.out.printf("Vowels in %-20s : %d%n",
                    String.valueOf(str), countVowels(str));
        }
    }
}
