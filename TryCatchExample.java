import java.io.FileReader;
import java.io.IOException;

public class TryCatchExample {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index is out of bounds.");
        }

        try {
            FileReader file = new FileReader("non_existent_file.txt");
            file.close();
        } catch (IOException e) {
            System.out.println("Error: Could not read or find the file.");
        }

        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        }
    }
}
