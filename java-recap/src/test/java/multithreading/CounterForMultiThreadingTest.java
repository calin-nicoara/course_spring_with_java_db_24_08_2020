package multithreading;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CounterForMultiThreadingTest {

    @Test
    public void testMultipleThreadOnCounter() {
        CounterForMultiThreading counterForMultiThreading = new CounterForMultiThreading();

        for(int i = 0; i < 10000; i++) {
            new Thread(() -> {

                int count = counterForMultiThreading.incrementAndGetCount();
                System.out.println("Current count: " + count + " from thread: " +
                        Thread.currentThread().getName());
            }).start();
        }

        ThreadUtil.sleep(2000);
        System.out.println("Final value: " + counterForMultiThreading.getCurrentCount());
    }

    @Test
    public void testMultipleThreadOnCounterAtomic() {
        CounterForMultiThreading counterForMultiThreading = new CounterForMultiThreading();

        for(int i = 0; i < 10000; i++) {
            new Thread(() -> {

                int count = counterForMultiThreading.incrementAndGetCountAtomic();
                System.out.println("Current count: " + count + " from thread: " +
                        Thread.currentThread().getName());
            }).start();
        }

        ThreadUtil.sleep(2000);
        System.out.println("Final value: " + counterForMultiThreading.getCurrentCountAtomic());
    }

    @Test
    public void testThreadLocal() {
        CounterForMultiThreading counterForMultiThreading = new CounterForMultiThreading();

        Runnable threadLocal = () -> {
            counterForMultiThreading.setId();
            ThreadUtil.sleep(new Random().nextInt(500));
            counterForMultiThreading.getId();
        };

        for(int i = 0; i < 5; i++) {
            new Thread(threadLocal).start();
        }


        ThreadUtil.sleep(2000);
    }
}
