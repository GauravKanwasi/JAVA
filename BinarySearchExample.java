import java.util.Scanner;
import java.util.Arrays;

public class BinarySearchExample {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take array size from the user
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input array elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Sort the array to apply binary search
        Arrays.sort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));

        // Take element to search
        System.out.print("Enter the element to search: ");
        int key = sc.nextInt();

        // Apply binary search
        int result = binarySearch(arr, key);

        // Output result
        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index: " + result);
        }

        sc.close();
    }

    // Binary search method
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                return mid;  // element found
            } else if (arr[mid] < key) {
                low = mid + 1; // search right half
            } else {
                high = mid - 1; // search left half
            }
        }
        return -1; // not found
    }
}
