public class NumberArray {

    // 1. Base class for encapsulation
    static class BaseArray {
        private int[] arr;

        public BaseArray(int[] arr) {
            this.arr = arr;
        }

        public int[] getArr() {
            return arr;
        }

        public void display() {
            System.out.print("Base Array: ");
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // 2. Subclass for logic
    static class CombinedArray extends BaseArray {
        private int[] arr2;
        private int[] combined;

        public CombinedArray(int[] arr1, int[] arr2) {
            super(arr1);
            this.arr2 = arr2;
            combineArrays();
        }

        private void combineArrays() {
            int[] arr1 = getArr(); // Use getter from parent
            combined = new int[arr1.length + arr2.length];
            int index = 0;

            for (int num : arr1) {
                combined[index++] = num;
            }
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

    // 3. Main execution entry point
    public static void main(String[] args) {
        int[] a1 = {1, 3, 5};
        int[] a2 = {2, 4, 6};

        CombinedArray obj = new CombinedArray(a1, a2);

        System.out.println("Executing Array Program:");
        System.out.println("-------------------------");
        
        obj.display();         // Calls method from BaseArray
        obj.displayCombined(); // Calls method from CombinedArray
        
        System.out.println("-------------------------");
    }
}
