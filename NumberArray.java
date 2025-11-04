class NumberArray {
    protected int[] arr;

    // Constructor to set the array
    NumberArray(int[] arr) {
        this.arr = arr;
    }

    // Method to display the array
    public void display() {
        System.out.print("Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

// Child class extending the parent
class CombinedArray extends NumberArray {
    private int[] arr2;
    private int[] combined;

    CombinedArray(int[] arr1, int[] arr2) {
        super(arr1); // Pass first array to parent class
        this.arr2 = arr2;
        combineArrays();
    }

    // Method to combine arrays
    private void combineArrays() {
        combined = new int[arr.length + arr2.length];

        for (int i = 0; i < arr.length; i++) {
            combined[i] = arr[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            combined[arr.length + i] = arr2[i];
        }
    }

    // Display combined result
    public void displayCombined() {
        System.out.print("Combined Array: ");
        for (int num : combined) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a1 = {1, 3, 5};
        int[] a2 = {2, 4, 6};

        CombinedArray obj = new CombinedArray(a1, a2);

        obj.display();        // Show first array
        obj.displayCombined(); // Show combined array
    }
}
