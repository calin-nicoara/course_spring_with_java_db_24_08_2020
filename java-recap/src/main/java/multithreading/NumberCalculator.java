package multithreading;

public class NumberCalculator {

    public static long computeBigNumber(int lastIndex) {
        long finalNumber = 0;
        for(int i= 0 ; i < lastIndex; i++) {
            finalNumber += i;
        }

        return finalNumber;
    }
}
