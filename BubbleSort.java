import java.util.Arrays;

public class BubbleSort {

    public void sort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort sorter = new BubbleSort();
        int[] data = { 64, 34, 25, 12, 22, 11, 90 };

        System.out.println("Unsorted array: " + Arrays.toString(data));
        sorter.sort(data);
        System.out.println("Sorted array: " + Arrays.toString(data));
    }
}
