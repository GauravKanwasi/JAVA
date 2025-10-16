public class LoopExamples {

    public static void main(String[] args) {

        System.out.println("--- Starting For Loop (counts 1 to 5) ---");
        for (int i = 1; i <= 5; i++) {
            System.out.println("For loop iteration: " + i);
        }

        System.out.println("\n------------------------------------------\n");

        System.out.println("--- Starting While Loop (counts 1 to 5) ---");
        int j = 1;
        while (j <= 5) {
            System.out.println("While loop iteration: " + j);
            j++;
        }
    }
}
