class MyThread extends Thread {
    public void run() {
        synchronized (this) {
            System.out.println("Thread " + Thread.currentThread().getName() + " started");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread " + Thread.currentThread().getName() + " finished");
            notify(); // Notify any waiting thread
        }
    }
}

public class mi {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        synchronized (thread1) {
            thread1.start();
            thread1.wait(); // Wait for thread1 to complete
        }

        synchronized (thread2) {
            thread2.start();
            thread2.wait(); // Wait for thread2 to complete
        }

        System.out.println("Both threads are completed");
    }
}
