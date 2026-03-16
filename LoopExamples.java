import java.util.*;
import java.util.stream.*;

public class LoopExamples {

    static int collatz(int n) {
        int steps = 0;
        while (n != 1) {
            n = (n % 2 == 0) ? n / 2 : 3 * n + 1;
            steps++;
        }
        return steps;
    }

    static int[] sieve(int limit) {
        boolean[] composite = new boolean[limit + 1];
        for (int i = 2; i * i <= limit; i++) {
            if (!composite[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    composite[j] = true;
                }
            }
        }
        return IntStream.rangeClosed(2, limit).filter(i -> !composite[i]).toArray();
    }

    static int[][] multiplicationTable(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }

    static String fizzbuzz(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0)      sb.append("FizzBuzz");
            else if (i % 3 == 0)  sb.append("Fizz");
            else if (i % 5 == 0)  sb.append("Buzz");
            else                   sb.append(i);
            if (i < n) sb.append(", ");
        }
        return sb.toString();
    }

    static long[] fibonacci(int count) {
        long[] fib = new long[count];
        fib[0] = 0;
        if (count > 1) fib[1] = 1;
        for (int i = 2; i < count; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    static void printPattern(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int sp = rows - i; sp > 0; sp--) System.out.print(" ");
            for (int star = 1; star <= 2 * i - 1; star++) System.out.print("*");
            System.out.println();
        }
    }

    static Map<Character, Integer> charFrequency(String s) {
        Map<Character, Integer> freq = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        return freq;
    }

    static int[] bubbleSort(int[] arr) {
        int[] a = arr.clone();
        boolean swapped;
        for (int i = 0; i < a.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j]; a[j] = a[j + 1]; a[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println("=== Basic For Loop (1 to 5) ===");
        for (int i = 1; i <= 5; i++) {
            System.out.println("  Iteration: " + i);
        }

        System.out.println("\n=== Basic While Loop (1 to 5) ===");
        int j = 1;
        while (j <= 5) {
            System.out.println("  Iteration: " + j);
            j++;
        }

        System.out.println("\n=== FizzBuzz (1 to 20) ===");
        System.out.println("  " + fizzbuzz(20));

        System.out.println("\n=== Fibonacci Sequence (first 10) ===");
        System.out.println("  " + Arrays.toString(fibonacci(10)));

        System.out.println("\n=== Primes up to 50 (Sieve of Eratosthenes) ===");
        System.out.println("  " + Arrays.toString(sieve(50)));

        System.out.println("\n=== Collatz Steps ===");
        for (int n : new int[]{6, 11, 27}) {
            System.out.println("  collatz(" + n + ") = " + collatz(n) + " steps");
        }

        System.out.println("\n=== Bubble Sort ===");
        int[] unsorted = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("  Before: " + Arrays.toString(unsorted));
        System.out.println("  After:  " + Arrays.toString(bubbleSort(unsorted)));

        System.out.println("\n=== Character Frequency (\"hello world\") ===");
        charFrequency("hello world").forEach((c, count) ->
            System.out.println("  '" + c + "' -> " + count));

        System.out.println("\n=== 4x4 Multiplication Table ===");
        int[][] table = multiplicationTable(4);
        for (int[] row : table) {
            System.out.print("  ");
            for (int val : row) System.out.printf("%4d", val);
            System.out.println();
        }

        System.out.println("\n=== Star Pyramid (5 rows) ===");
        printPattern(5);
    }
}
