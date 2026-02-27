class SharedResource {

    synchronized void printNumbers(String threadName) {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println(threadName + " : " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " interrupted: " + e.getMessage());
        }
    }
}

class WorkerThread extends Thread {
    SharedResource resource;
    String tName;

    WorkerThread(SharedResource resource, String name) {
        this.resource = resource;
        this.tName = name;
    }

    public void run() {
        try {
            resource.printNumbers(tName);
        } catch (Exception e) {
            System.out.println("Error in thread " + tName + ": " + e.getMessage());
        }
    }
}

public class synbytc {
    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        WorkerThread t1 = new WorkerThread(resource, "Thread-1");
        WorkerThread t2 = new WorkerThread(resource, "Thread-2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("Execution finished.");
    }
}