package multithreading;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.*;

public class ConcurrencyApiTest {

    @Test
    public void testExecutorWithRunnable() {
        Runnable runnable = () -> {
            ThreadUtil.sleep(1000);

            long value = NumberCalculator.computeBigNumber(1000);
            System.out.println("Value is :" + value + " for thread:" + Thread.currentThread().getName());
        };

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for(int i = 0; i < 9; i++) {
            executorService.execute(runnable);
        }

        ThreadUtil.sleep(2500);
    }

    @Test
    public void testCallable() {
        Callable<Long> getResultCallable = () -> {
            ThreadUtil.sleep(1000);
            return NumberCalculator.computeBigNumber(1000);
//            System.out.println("Value is :" + value + " for thread:" + Thread.currentThread().getName());
        };

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Future<Long> submit = executorService.submit(getResultCallable);

        try {
            Long result = submit.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testScheduledExecutor() {
        Runnable runnable = () -> {
            ThreadUtil.sleep(5000);
            long value = NumberCalculator.computeBigNumber(1000);
            System.out.println("Value is :" + value + " for thread:" + Thread.currentThread().getName());
        };

        ScheduledExecutorService scheduledExecutorService = Executors
                .newScheduledThreadPool(2);

//        scheduledExecutorService.scheduleWithFixedDelay(runnable,
//                2,2, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(runnable,
                1, 2, TimeUnit.SECONDS);


        ThreadUtil.sleep(15000);
    }
}
