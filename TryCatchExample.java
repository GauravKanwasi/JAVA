import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EnhancedTryCatchExample {

    public static void main(String[] args) {
        handleArrayException();
        handleFileException();
        handleArithmeticException();
        handleNumberFormatException();
        handleNullPointerException();
    }

    static void handleArrayException() {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Error: " + e.getMessage());
        } finally {
            System.out.println("Array operation completed.\n");
        }
    }

    static void handleFileException() {
        try (BufferedReader reader = new BufferedReader(new FileReader("non_existent_file.txt"))) {
            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        } finally {
            System.out.println("File operation completed.\n");
        }
    }

    static void handleArithmeticException() {
        try {
            int result = 10 / 0;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Error: " + e.getMessage());
        } finally {
            System.out.println("Arithmetic operation completed.\n");
        }
    }

    static void handleNumberFormatException() {
        try {
            int value = Integer.parseInt("ABC");
            System.out.println(value);
        } catch (NumberFormatException e) {
            System.out.println("Number Format Error: " + e.getMessage());
        } finally {
            System.out.println("Number conversion completed.\n");
        }
    }

    static void handleNullPointerException() {
        try {
            String text = null;
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Null Pointer Error: Object reference is null.");
        } finally {
            System.out.println("Null check completed.\n");
        }
    }
}
