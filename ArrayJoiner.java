import java.util.Arrays;

public class ArrayJoiner {
    public static void main(String[] args) {
        int[] firstArray = {10, 20, 30};
        int[] secondArray = {40, 50, 60, 70};

        int[] joinedArray = joinArrays(firstArray, secondArray);
        
        System.out.println("Joined Array: " + Arrays.toString(joinedArray));
    }

    public static int[] joinArrays(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        
        return result;
    }
}
