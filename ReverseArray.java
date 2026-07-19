import java.util.Arrays;

public class ReverseArray {

    static int[] reverseArray(int[] arr) {
        int[] rev = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            rev[i] = arr[arr.length - 1 - i];
        }

        return rev;
    }

    static void printArray(String message, int[] arr) {
        System.out.println(message + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        printArray("Original Array: ", arr);

        int[] reversed = reverseArray(arr);

        printArray("Reversed Array: ", reversed);
    }
}
