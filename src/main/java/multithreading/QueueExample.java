package multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class QueueExample {
    //static int i = 0;

    static final Object lock = new Object();

    static final Executor executor = Executors.newFixedThreadPool(10);

    static final BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);

    public static void main(String[] args) {
        runAsync("1");
        runAsync("2");
        runAsync("3");

        Runnable worker = () -> {
            int i = 0;
            String  id = null;
            while (true) {
                try {
                    id = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i = i + 1;
                System.out.println("Thread " + id + ": " + i);
            }
        };

        executor.execute(worker);

    }

    public static synchronized void syncMethod(){
//        synchronized (ThreadExample.class) {
//
//        }
    }

    public static void runAsync(String threadId) {
        Runnable runnable = () -> {
            while (true){
                try {
                    queue.put(threadId);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        executor.execute(runnable);
    }

}
