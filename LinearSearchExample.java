import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LinearSearchExample {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] data = {10, 20, 30, 40, 30, 50, 60, 30};

        System.out.println("========================================");
        System.out.println("      LINEAR SEARCH DEMONSTRATION");
        System.out.println("========================================");

        boolean run = true;

        while (run) {

            displayArray(data);

            int target = getInteger("Enter number to search: ");

            int firstIndex = findFirstIndex(data, target);
            List<Integer> allIndices = findAllIndices(data, target);

            System.out.println("\n------------ RESULT ------------");

            if (firstIndex == -1) {
                System.out.println("Number " + target + " not found.");
            } else {
                System.out.println("Number Found");
                System.out.println("First Occurrence : " + firstIndex);
                System.out.println("All Indices      : " + allIndices);
                System.out.println("Total Occurrences: " + allIndices.size());
            }

            System.out.println("--------------------------------");

            System.out.print("\nSearch again? (Y/N): ");
            String choice = scanner.next();

            if (!choice.equalsIgnoreCase("Y")) {
                run = false;
            }

            System.out.println();
        }

        System.out.println("Thank you for using Linear Search!");
        scanner.close();
    }

    static void displayArray(int[] arr) {
        System.out.print("\nArray: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    static int getInteger(String message) {

        while (true) {
            System.out.print(message);

            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }

            System.out.println("Invalid input! Please enter an integer.");
            scanner.next();
        }
    }

    static int findFirstIndex(int[] arr, int key) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }

        return -1;
    }

    static List<Integer> findAllIndices(int[] arr, int key) {

        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                indices.add(i);
        }

        return indices;
    }
}
