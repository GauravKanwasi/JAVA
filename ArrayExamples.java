import java.util.Arrays;

public class ArrayExamples {

    public static void main(String[] args) {
        System.out.println("--- 1D Array Example ---");
        // A 1D array represents a simple linear sequence of elements
        int[] oneDArray = {1, 2, 3, 4, 5};
        // Enhanced for-loop is cleaner for read-only traversal
        for (int num : oneDArray) {
            System.out.print(num + " ");
        }
        // Arrays.toString() is the most efficient way to print a flat array directly
        System.out.println("\nUsing Arrays.toString(): " + Arrays.toString(oneDArray));
        System.out.println("Accessing element at index 2: " + oneDArray[2]);

        
        System.out.println("\n--- 2D Array Example ---");
        // A 2D array is an array of arrays, representing a matrix or grid (Rows x Columns)
        int[][] twoDArray = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        for (int[] row : twoDArray) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println("Accessing element at [1][1] (Row 1, Col 1): " + twoDArray[1][1]);
        System.out.println("\n--- 3D Array Example ---");
        // A 3D array is an array of 2D arrays, useful for layered data (Layer x Row x Column)
        int[][][] threeDArray = {
            {
                {1, 2},
                {3, 4}
            },
            {
                {5, 6},
                {7, 8}
            }
        };
        // Standard loops are best here when you need to track the current index (e.g., printing the layer number)
        for (int layer = 0; layer < threeDArray.length; layer++) {
            System.out.println("Layer " + layer + ":");
            for (int row = 0; row < threeDArray[layer].length; row++) {
                for (int col = 0; col < threeDArray[layer][row].length; col++) {
                    System.out.print(threeDArray[layer][row][col] + " ");
                }
                System.out.println();
            }
        }
        System.out.println("Accessing element at [1][0][1] (Layer 1, Row 0, Col 1): " + threeDArray[1][0][1]);
        
        // Arrays.deepToString() handles multi-dimensional arrays automatically
        System.out.println("\nBonus: Quick print for multi-dimensional arrays -> " + Arrays.deepToString(threeDArray));
    }
}
