import java.util.Arrays;

public class SelectionSort {

    /**
     * Sorts an integer array in-place using Selection Sort.
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; 
        }

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Skip self-swaps to prevent unnecessary memory write operations
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = { 29, 10, 14, 37, 13 };
        
        System.out.println("Original Array:                " + Arrays.toString(data));
        selectionSort(data);
        System.out.println("Sorted Array (Selection Sort): " + Arrays.toString(data));
    }
}
