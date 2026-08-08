import java.util.InputMismatchException;
import java.util.Scanner;

public class AdvancedCalculator {

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

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public double squareRoot(double a) {
        if (a < 0) {
            throw new ArithmeticException("Square root of a negative number is not real.");
        }
        return Math.sqrt(a);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdvancedCalculator calculator = new AdvancedCalculator();
        boolean keepRunning = true;

        System.out.println("=================================");
        System.out.println("       Advanced Calculator");
        System.out.println("=================================");

        while (keepRunning) {
            try {
                System.out.println("\nChoose Operation:");
                System.out.println("1. Addition (+)");
                System.out.println("2. Subtraction (-)");
                System.out.println("3. Multiplication (×)");
                System.out.println("4. Division (÷)");
                System.out.println("5. Modulus (%)");
                System.out.println("6. Power (^)");
                System.out.println("7. Square Root (√)");
                System.out.println("8. Exit");
                System.out.print("Enter choice (1-8): ");
                
                int choice = scanner.nextInt();

                if (choice == 8) {
                    System.out.println("Exiting the calculator. Goodbye!");
                    keepRunning = false;
                    continue;
                }

                if (choice < 1 || choice > 8) {
                    System.out.println("\nInvalid choice. Please enter a number between 1 and 8.");
                    continue;
                }

                double num1 = 0, num2 = 0;

                // Square root only needs one number
                if (choice == 7) {
                    System.out.print("Enter the number: ");
                    num1 = scanner.nextDouble();
                } else {
                    System.out.print("Enter first number: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = scanner.nextDouble();
                }

                System.out.print("\nResult: ");
                
                // Using Enhanced Switch Statement (Java 14+)
                switch (choice) {
                    case 1 -> System.out.println(num1 + " + " + num2 + " = " + calculator.add(num1, num2));
                    case 2 -> System.out.println(num1 + " - " + num2 + " = " + calculator.subtract(num1, num2));
                    case 3 -> System.out.println(num1 + " × " + num2 + " = " + calculator.multiply(num1, num2));
                    case 4 -> System.out.println(num1 + " ÷ " + num2 + " = " + calculator.divide(num1, num2));
                    case 5 -> System.out.println(num1 + " % " + num2 + " = " + calculator.modulus(num1, num2));
                    case 6 -> System.out.println(num1 + " ^ " + num2 + " = " + calculator.power(num1, num2));
                    case 7 -> System.out.println("√" + num1 + " = " + calculator.squareRoot(num1));
                }

            } catch (ArithmeticException e) {
                System.out.println("\nMath Error: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("\nInput Error: Please enter valid numeric values.");
                scanner.nextLine(); // Clear the invalid input from the scanner buffer
            }
        }

        scanner.close();
    }
}
