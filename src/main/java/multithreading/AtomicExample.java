package multithreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicExample {
    static final AtomicInteger i = new AtomicInteger(0);

    static final Object lock = new Object();

    public static void main(String[] args) {
        runAsync("1");
        runAsync("2");
        runAsync("3");

    }

    public static synchronized void syncMethod(){
//        synchronized (ThreadExample.class) {
//
//        }
    }

    public static void runAsync(String threadId) {
        Runnable runnable = () -> {
            while (true){
                System.out.println("Thread " + threadId + ": " + i.incrementAndGet());

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
