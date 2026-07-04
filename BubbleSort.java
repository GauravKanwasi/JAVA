import java.util.Arrays;

public class BubbleSort {

    public enum Order {
        ASCENDING,
        DESCENDING
    }

    public void sort(int[] arr) {
        sort(arr, Order.ASCENDING);
    }

    public void sort(int[] arr, Order order) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                boolean shouldSwap = order == Order.ASCENDING
                        ? arr[j] > arr[j + 1]
                        : arr[j] < arr[j + 1];

                if (shouldSwap) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(String message, int[] arr) {
        System.out.println(message + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        BubbleSort sorter = new BubbleSort();

        int[] ascending = {64, 34, 25, 12, 22, 11, 90};
        int[] descending = ascending.clone();

        printArray("Original: ", ascending);

        sorter.sort(ascending);
        printArray("Ascending: ", ascending);

        sorter.sort(descending, Order.DESCENDING);
        printArray("Descending: ", descending);
    }
}
