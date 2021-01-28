package multithreading;

public class WaitNotifyExample {
    static volatile int i = 0;

    static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        runAsync("1");
        runAsync("2");
        runAsync("3");

        Thread.sleep(5000);
        synchronized (WaitNotifyExample.class) {
            WaitNotifyExample.class.notify();
        }

    }

    public static synchronized void syncMethod(){
//        synchronized (ThreadExample.class) {
//
//        }
    }

    public static void runAsync(String threadId) {
        Runnable runnable = () -> {
            while (true){
                synchronized (WaitNotifyExample.class) {
                    i = i + 1;
                    System.out.println("Thread " + threadId + ": " + i);
                    try {
                        WaitNotifyExample.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    WaitNotifyExample.class.notifyAll();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

}
