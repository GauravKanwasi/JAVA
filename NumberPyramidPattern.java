import java.util.Scanner;

public class NumberPyramidPattern {

    public static void printNumberPyramid(int rows) {
        int number = 1;

        for (int i = 1; i <= rows; i++) {

            for (int j = 1; j <= rows - i; j++) {
                System.out.print("   ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.printf("%3d", number++);
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        if (rows <= 0) {
            System.out.println("Please enter a positive number.");
            return;
        }

        System.out.println("\nNumber Pyramid:\n");
        printNumberPyramid(rows);

        scanner.close();
    }
}
