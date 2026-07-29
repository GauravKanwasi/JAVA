import java.util.Arrays;

public class NumberArray {

    static class BaseArray {
        private int[] array;

        public BaseArray(int[] array) {
            this.array = Arrays.copyOf(array, array.length);
        }

        public int[] getArray() {
            return Arrays.copyOf(array, array.length);
        }

        public int size() {
            return array.length;
        }

        public int sum() {
            int sum = 0;
            for (int num : array) {
                sum += num;
            }
            return sum;
        }

        public void display() {
            System.out.println("Array : " + Arrays.toString(array));
            System.out.println("Size  : " + size());
            System.out.println("Sum   : " + sum());
        }
    }

    static class CombinedArray extends BaseArray {
        private int[] secondArray;
        private int[] combinedArray;

        public CombinedArray(int[] firstArray, int[] secondArray) {
            super(firstArray);
            this.secondArray = Arrays.copyOf(secondArray, secondArray.length);
            combineArrays();
        }

        private void combineArrays() {
            int[] first = getArray();
            combinedArray = new int[first.length + secondArray.length];

            System.arraycopy(first, 0, combinedArray, 0, first.length);
            System.arraycopy(secondArray, 0, combinedArray, first.length, secondArray.length);
        }

        public double average() {
            int sum = 0;
            for (int num : combinedArray) {
                sum += num;
            }
            return (double) sum / combinedArray.length;
        }

        public int max() {
            int max = combinedArray[0];
            for (int num : combinedArray) {
                if (num > max) {
                    max = num;
                }
            }
            return max;
        }

        public int min() {
            int min = combinedArray[0];
            for (int num : combinedArray) {
                if (num < min) {
                    min = num;
                }
            }
            return min;
        }

        @Override
        public void display() {
            super.display();
            System.out.println("Combined Array : " + Arrays.toString(combinedArray));
            System.out.println("Average        : " + average());
            System.out.println("Maximum        : " + max());
            System.out.println("Minimum        : " + min());
        }
    }

    public static void main(String[] args) {

        int[] first = {1, 3, 5, 7};
        int[] second = {2, 4, 6, 8};

        CombinedArray array = new CombinedArray(first, second);

        System.out.println("===== NUMBER ARRAY PROGRAM =====");
        array.display();
        System.out.println("================================");
    }
}
