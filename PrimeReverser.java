public class PrimeReverser {

    public static void main(String[] args) {
        final int START = 2;
        final int END = 200;

        System.out.println("Prime Numbers and Their Reversals");
        System.out.println("Range: " + START + " to " + END);
        System.out.println("------------------------------------------------------");
        System.out.printf("%-8s %-10s %-12s%n", "Prime", "Reverse", "Reverse Prime");
        System.out.println("------------------------------------------------------");

        int count = 0;
        int emirpCount = 0;

        for (int number = START; number <= END; number++) {
            if (isPrime(number)) {
                int reversed = reverseNumber(number);
                boolean reversePrime = isPrime(reversed);

                System.out.printf(
                        "%-8d %-10d %-12s%n",
                        number,
                        reversed,
                        reversePrime ? "Yes" : "No"
                );

                count++;
                if (reversePrime && reversed != number) {
                    emirpCount++;
                }
            }
        }

        System.out.println("------------------------------------------------------");
        System.out.println("Total Prime Numbers : " + count);
        System.out.println("Emirp Numbers       : " + emirpCount);
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        if (n == 2) {
            return true;
        }

        if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int reverseNumber(int n) {
        int reversed = 0;

        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }

        return reversed;
    }
}
