public class PrimeReverser {

    public static void main(String[] args) {
        System.out.println("Prime Numbers and their Reversals (1 to 200):");
        System.out.println("------------------------------------------");

        for (int number = 2; number <= 200; number++) {
            if (isPrime(number)) {
                int reversedNumber = reverseNumber(number);
                System.out.println("Prime: " + number + ", Reversed: " + reversedNumber);
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int reverseNumber(int n) {
        int reversed = 0;
        int original = n;

        while (original != 0) {
            int digit = original % 10;
            reversed = reversed * 10 + digit;
            original /= 10;
        }
        return reversed;
    }
}