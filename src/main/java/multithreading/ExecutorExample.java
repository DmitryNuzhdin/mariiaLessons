package multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorExample {
    static final AtomicInteger i = new AtomicInteger(0);

    static final Object lock = new Object();

    static final ExecutorService executor = Executors.newFixedThreadPool(10);

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
        executor.execute(runnable);
    }

}
