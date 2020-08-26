package ro.esolacad.springcourse.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class TestScheduler {

//    @Scheduled(fixedDelay = 2000)
    public void testFixedDelay() {
//        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("------------------");
            System.out.println("---- FIXED DELAY ---");
            System.out.println("------------------");
//        });
    }

//    @Scheduled(fixedRate = 2000)
    public void testFixedRate() {
//        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("------------------");
            System.out.println("---- FIXED RATE ---");
            System.out.println("------------------");
//        });
    }

    @Scheduled(cron = "*/3 * 12 * * ?", zone="Europe/Bucharest")
    public void testCron() {
        System.out.println("------------------");
        System.out.println("---- CRON ---");
        System.out.println("------------------");
    }
}
