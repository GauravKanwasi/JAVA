public class ArrayExamples {

    public static void main(String[] args) {
        
        System.out.println("--- 1D Array Example ---");
        int[] oneDArray = {1, 2, 3, 4, 5};
        
        for (int i = 0; i < oneDArray.length; i++) {
            System.out.print(oneDArray[i] + " ");
        }
        System.out.println("\nAccessing element at index 2: " + oneDArray[2]);

        
        System.out.println("\n--- 2D Array Example ---");
        int[][] twoDArray = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        for (int i = 0; i < twoDArray.length; i++) {
            for (int j = 0; j < twoDArray[i].length; j++) {
                System.out.print(twoDArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Accessing element at [1][1]: " + twoDArray[1][1]);


        System.out.println("\n--- 3D Array Example ---");
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

        for (int i = 0; i < threeDArray.length; i++) {
            System.out.println("Layer " + i + ":");
            for (int j = 0; j < threeDArray[i].length; j++) {
                for (int k = 0; k < threeDArray[i][j].length; k++) {
                    System.out.print(threeDArray[i][j][k] + " ");
                }
                System.out.println();
            }
        }
        System.out.println("Accessing element at [1][0][1]: " + threeDArray[1][0][1]);
    }
}
