package multithreading;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterForMultiThreading {

    private static AtomicInteger atomicCounter = new AtomicInteger(0);
    private static int counter = 0;

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public int incrementAndGetCount() {
        ThreadUtil.sleep(new Random().nextInt(200));

        synchronized (this) {
            return ++counter;
        }
    }

    public int getCurrentCount() {
        return counter;
    }

    public int incrementAndGetCountAtomic() {
        ThreadUtil.sleep(new Random().nextInt(200));
        return atomicCounter.incrementAndGet();
    }

    public int getCurrentCountAtomic() {
        return atomicCounter.get();
    }

    public void setId() {
        int value = atomicCounter.incrementAndGet();
        System.out.println("Set Id: " + value + " for thread:" + Thread.currentThread().getName());
        threadLocal.set(value);
    }

    public Integer getId() {
        Integer value = threadLocal.get();
        System.out.println("Get Id: " + value + " for thread:" + Thread.currentThread().getName());
        return value;
    }
}
