import java.util.Scanner;

public class TernaryExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int a = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int b = scanner.nextInt();

        String result = (a > b)
                ? "The larger number is " + a
                : (a < b)
                    ? "The larger number is " + b
                    : "Both numbers are equal.";

        System.out.println(result);

        scanner.close();
    }
}
