public class SwapUsingXOR {
    static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }
    public static void main(String[] args) {
        int[] values = {5, 10};
        System.out.println("Before Swap:");
        System.out.println("a = " + values[0]);
        System.out.println("b = " + values[1]);
        swap(values, 0, 1);
        System.out.println("\nAfter Swap:");
        System.out.println("a = " + values[0]);
        System.out.println("b = " + values[1]);
    }
}
