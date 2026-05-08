import java.util.Scanner;

public class SimpleCalculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    public double modulus(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Modulus by zero is not allowed.");
        }
        return a % b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleCalculator calculator = new SimpleCalculator();

        System.out.println("=================================");
        System.out.println("      Advanced Calculator");
        System.out.println("=================================");

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.println("\nChoose Operation");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Modulus");

        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        double result;

        switch (choice) {
            case 1:
                result = calculator.add(num1, num2);
                System.out.println("\nResult: " + num1 + " + " + num2 + " = " + result);
                break;

            case 2:
                result = calculator.subtract(num1, num2);
                System.out.println("\nResult: " + num1 + " - " + num2 + " = " + result);
                break;

            case 3:
                result = calculator.multiply(num1, num2);
                System.out.println("\nResult: " + num1 + " × " + num2 + " = " + result);
                break;

            case 4:
                try {
                    result = calculator.divide(num1, num2);
                    System.out.println("\nResult: " + num1 + " ÷ " + num2 + " = " + result);
                } catch (ArithmeticException e) {
                    System.out.println("\nError: " + e.getMessage());
                }
                break;

            case 5:
                try {
                    result = calculator.modulus(num1, num2);
                    System.out.println("\nResult: " + num1 + " % " + num2 + " = " + result);
                } catch (ArithmeticException e) {
                    System.out.println("\nError: " + e.getMessage());
                }
                break;

            default:
                System.out.println("\nInvalid choice.");
        }

        scanner.close();
    }
}