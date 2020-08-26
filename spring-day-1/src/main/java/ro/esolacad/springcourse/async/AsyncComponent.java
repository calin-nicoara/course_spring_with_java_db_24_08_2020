package ro.esolacad.springcourse.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncComponent {

    @Async("myExecutor")
    public void doSomethingAsync() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Do something async:" + Thread.currentThread().getName());
    }

    @Async
    public Future<String> returnStringAsync() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new AsyncResult<>("Async String");
    }
}
