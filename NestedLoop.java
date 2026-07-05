public class NestedLoop {
    public static void main(String[] args) {
        int rows = 3;
        int cols = 2;

        System.out.println("Nested Loop Demonstration");
        System.out.println("-------------------------");

        for (int i = 0; i < rows; i++) {
            System.out.println("Outer Loop Iteration: " + i);

            for (int j = 0; j < cols; j++) {
                System.out.printf("  Inner Loop -> i = %d, j = %d%n", i, j);
            }

            System.out.println();
        }

        System.out.println("Execution Completed.");
    }
}
