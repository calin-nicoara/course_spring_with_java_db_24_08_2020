package multithreading;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberCalculatorThreadTest {

    @Test
    public void testCalculatorThread() {
        NumberCalculatorThread numberCalculatorThread = new NumberCalculatorThread();

        System.out.println("Current thread: " + Thread.currentThread().getName());

        numberCalculatorThread.start();

        System.out.println("Main thread: " + Thread.currentThread().getName());

        ThreadUtil.sleep(1500);
    }

    @Test
    public void testRunnable() {
        Runnable runnable = () -> {
            int millis = 1000;

            ThreadUtil.sleep(millis);

            long result = NumberCalculator.computeBigNumber(25000);
            System.out.println("The number is: " + result + " from thread with runnable:" + Thread.currentThread().getName());
        };

        Thread thread = new Thread(runnable);

        System.out.println("Current thread: " + Thread.currentThread().getName());
        thread.start();
        System.out.println("Main thread: " + Thread.currentThread().getName());

        ThreadUtil.sleep(1500);
    }
}
