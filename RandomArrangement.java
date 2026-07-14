import java.util.Arrays;
import java.util.Random;

public class RandomArrangement {

    private static final Random random = new Random();

    public static void shuffle(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(numbers));

        shuffle(numbers);

        System.out.println("Randomly Arranged Array:");
        System.out.println(Arrays.toString(numbers));
    }
}
