public class VowelCounter {

    public static int countVowels(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int vowelCount = 0;
        String lowerStr = str.toLowerCase();

        for (int i = 0; i < lowerStr.length(); i++) {
            char ch = lowerStr.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            }
        }

        return vowelCount;
    }

    public static void main(String[] args) {
        String testString1 = "Hello World";
        String testString2 = "Programming is Fun";
        String testString3 = "AEIOUaeiou";
        String testString4 = "Rhythm";

        System.out.println("Vowels in \"" + testString1 + "\": " + countVowels(testString1));
        System.out.println("Vowels in \"" + testString2 + "\": " + countVowels(testString2));
        System.out.println("Vowels in \"" + testString3 + "\": " + countVowels(testString3));
        System.out.println("Vowels in \"" + testString4 + "\": " + countVowels(testString4));
    }
}
