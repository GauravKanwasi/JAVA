import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * A robust example of Linear Search in Java.
 * Features: User input, reusable methods, and finding multiple occurrences.
 */
public class LinearSearchExample {

    public static void main(String[] args) {
        // 1. Initialize data and Scanner
        Scanner scanner = new Scanner(System.in);
        int[] data = {10, 20, 30, 40, 30, 50, 60, 30}; // Note: contains duplicate 30s
        
        System.out.println("Array contents: [10, 20, 30, 40, 30, 50, 60, 30]");
        System.out.print("Enter the number you are looking for: ");
        
        // 2. Validate input
        if (scanner.hasNextInt()) {
            int target = scanner.nextInt();

            // 3. Perform search using the helper method
            List<Integer> resultIndices = findAllIndices(data, target);

            // 4. Output results
            if (resultIndices.isEmpty()) {
                System.out.println("Result: The number " + target + " was not found in the array.");
            } else {
                System.out.println("Result: Number found at index/indices: " + resultIndices);
            }
        } else {
            System.out.println("Error: Please enter a valid integer.");
        }

        scanner.close();
    }

    /**
     * Searches the array and returns a list of every index where the target is found.
     * * @param arr The array to search through
     * @param key The value to look for
     * @return A List of integers representing the indices
     */
    public static List<Integer> findAllIndices(int[] arr, int key) {
        List<Integer> indices = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                indices.add(i); // Collect all matches
            }
        }
        return indices;
    }
}
