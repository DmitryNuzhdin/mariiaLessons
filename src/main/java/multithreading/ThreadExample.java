package multithreading;

import java.io.IOException;
import java.net.ServerSocket;

public class ThreadExample {
    static volatile int i = 0;

    static final Object lock = new Object();

    public static void main(String[] args) throws IOException {
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
                synchronized (ThreadExample.class) {
                    i = i + 1;
                    System.out.println("Thread " + threadId + ": " + i);
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
