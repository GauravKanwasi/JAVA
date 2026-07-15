import java.util.Arrays;

public class OptimizedBubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        while (n > 1) {
            int lastSwap = 0;

            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    lastSwap = i;
                }
            }

            if (lastSwap == 0) {
                break;
            }

            n = lastSwap;
        }
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] data1 = {64, 34, 25, 12, 22, 11, 90};
        int[] data2 = {10, 20, 30, 40, 50};
        int[] data3 = {5, 1, 4, 2, 8, 0, 2};

        System.out.println("Original: ");
        printArray(data1);
        bubbleSort(data1);
        System.out.println("Sorted: ");
        printArray(data1);

        System.out.println();

        System.out.println("Original: ");
        printArray(data2);
        bubbleSort(data2);
        System.out.println("Sorted: ");
        printArray(data2);

        System.out.println();

        System.out.println("Original: ");
        printArray(data3);
        bubbleSort(data3);
        System.out.println("Sorted: ");
        printArray(data3);
    }
}
