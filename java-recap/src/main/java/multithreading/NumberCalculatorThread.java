package multithreading;

public class NumberCalculatorThread extends Thread{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long result = NumberCalculator.computeBigNumber(10000);
        System.out.println("The number is: " + result + " from thread:" + Thread.currentThread().getName());
    }
}
