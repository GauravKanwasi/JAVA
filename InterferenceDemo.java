public class InterferenceDemo {

    private static final int INCREMENTS_PER_THREAD = 1_000_000;
    private static final int TEST_RUNS = 5;

    private int counter;

    private void incrementCounter() {
        for (int i = 0; i < INCREMENTS_PER_THREAD; i++) {
            counter++;
        }
    }

    public void runTest() {
        for (int run = 1; run <= TEST_RUNS; run++) {
            counter = 0;

            Thread thread1 = new Thread(this::incrementCounter, "Worker-1");
            Thread thread2 = new Thread(this::incrementCounter, "Worker-2");

            long start = System.nanoTime();

            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            long end = System.nanoTime();

            int expected = INCREMENTS_PER_THREAD * 2;

            System.out.println("Run #" + run);
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + counter);
            System.out.println("Lost     : " + (expected - counter));
            System.out.println("Status   : " + (counter == expected ? "No interference" : "Thread interference detected"));
            System.out.printf("Time     : %.3f ms%n%n", (end - start) / 1_000_000.0);
        }
    }

    public static void main(String[] args) {
        new InterferenceDemo().runTest();
    }
}
