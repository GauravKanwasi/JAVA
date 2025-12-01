public class Main {

    static class NumberArray {
        protected int[] arr;

        NumberArray(int[] arr) {
            this.arr = arr;
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

        CombinedArray(int[] arr1, int[] arr2) {
            super(arr1);
            this.arr2 = arr2;
            combineArrays();
        }

        private void combineArrays() {
            combined = new int[arr.length + arr2.length];
            int index = 0;

            for (int num : arr) {
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

    public static void main(String[] args) {
        int[] a1 = {1, 3, 5};
        int[] a2 = {2, 4, 6};

        CombinedArray obj = new CombinedArray(a1, a2);

        obj.display();
        obj.displayCombined();
    }
}