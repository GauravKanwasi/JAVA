import java.util.Scanner;
import java.util.Arrays;

public class BinarySearchExample {
    public static void main(String[] args) {
        // Using try-with-resources to automatically close the Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number of elements: ");
            int n = sc.nextInt();
            
            if (n <= 0) {
                System.out.println("Array size must be greater than 0.");
                return;
            }

            int[] arr = new int[n];
            
            System.out.println("Enter the elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);
            System.out.println("Sorted array: " + Arrays.toString(arr));

            System.out.print("Enter the element to search: ");
            int key = sc.nextInt();

            int result = binarySearch(arr, key);

            if (result == -1) {
                System.out.println("Element not found in the array.");
            } else {
                System.out.println("Element found at index: " + result);
            }
        }
    }

    /**
     * Performs a binary search on a sorted integer array.
     */
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // Using low + (high - low) / 2 prevents integer overflow for very large arrays
            int mid = low + (high - low) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
