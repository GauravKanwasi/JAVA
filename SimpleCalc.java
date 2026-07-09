import java.util.Scanner;

public class SimpleCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;

        System.out.println("\n===== Calculator Results =====");
        System.out.println("Addition       : " + sum);
        System.out.println("Subtraction    : " + difference);
        System.out.println("Multiplication : " + product);

        if (num2 != 0) {
            double quotient = num1 / num2;
            double remainder = num1 % num2;

            System.out.println("Division       : " + quotient);
            System.out.println("Remainder      : " + remainder);
        } else {
            System.out.println("Division       : Cannot divide by zero.");
            System.out.println("Remainder      : Undefined.");
        }

        scanner.close();
    }
}
