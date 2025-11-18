class PrimeReverse {
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    static int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + (n % 10);
            n = n / 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println("Prime Numbers and Their Reverses:");
        for (int i = 1; i <= 100; i++) {
            if (isPrime(i)) {
                int r = reverse(i);
                System.out.println(i + " --> " + r);
            }
        }
    }
}
