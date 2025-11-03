public class InterferenceDemo {

    // 1. The shared resource
    private int counter = 0;

    public void runTest() {
        // 2. Create two tasks (Runnables) that modify the shared resource
        Runnable task1 = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter++; // Not an atomic operation!
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter++; // Not an atomic operation!
            }
        };

        // 3. Create and start two threads to run the tasks
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        
        thread1.start();
        thread2.start();

        try {
            // 4. Wait for both threads to finish
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 5. Print the result
        System.out.println("Expected result: 2000000");
        System.out.println("Actual result:   " + counter);
    }

    public static void main(String[] args) {
        new InterferenceDemo().runTest();
    }
}
