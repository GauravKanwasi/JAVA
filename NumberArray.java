public class Main {

    static class NumberArray {
        private int[] arr; // Private for encapsulation

        public NumberArray(int[] arr) {
            this.arr = arr;
        }

        public int[] getArr() {
            return arr; // Public getter method
        }

        public void display() {
            System.out.print("Array: ");
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    static class CombinedArray extends NumberArray {
        private int[] arr2;
        private int[] combined;

        public CombinedArray(int[] arr1, int[] arr2) {
            super(arr1);
            this.arr2 = arr2;
            combineArrays();
        }

        private void combineArrays() {
            // Use the getter from the parent class
            int[] arr1 = getArr();
            combined = new int[arr1.length + arr2.length];
            int index = 0;

            // Copy elements from arr1
            for (int num : arr1) {
                combined[index++] = num;
            }
            // Copy elements from arr2
            for (int num : arr2) {
                combined[index++] = num;
            }
        }

        public void displayCombined() {
            System.out.print("Combined Array: ");
            for (int num : combined) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] a1 = {1, 3, 5};
        int[] a2 = {2, 4, 6};

        CombinedArray obj = new CombinedArray(a1, a2);

        System.out.println("Executing Array Program:");
        System.out.println("-------------------------");
        
        // Displays the parent array (a1)
        obj.display();
        
        // Displays the combined array (a1 + a2)
        obj.displayCombined();
        
        System.out.println("-------------------------");
    }
}
