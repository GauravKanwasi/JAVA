class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] rev = new int[arr.length];
        int index = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            rev[index++] = arr[i];
        }

        System.out.print("Original: ");
        for (int i : arr) System.out.print(i + " ");

        System.out.print("\nReversed: ");
        for (int i : rev) System.out.print(i + " ");
    }
}
