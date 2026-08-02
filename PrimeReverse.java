class PrimeReverse {

    static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    static int reverse(int n) {
        return Integer.parseInt(new StringBuilder(String.valueOf(n)).reverse().toString());
    }

    public static void main(String[] args) {
        System.out.printf("%-10s %-10s %-10s%n", "Prime", "Reverse", "Prime?");
        System.out.println("--------------------------------");

        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) {
                int rev = reverse(i);
                System.out.printf("%-10d %-10d %-10s%n",
                        i, rev, isPrime(rev) ? "Yes" : "No");
            }
        }
    }
}
