package ro.esolacad.springcourse.async;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UseAsyncComponent {

    private final AsyncComponent asyncComponent;

    public void doSomething() {
        System.out.println("Start something: " + Thread.currentThread().getName());
        asyncComponent.doSomethingAsync();
        System.out.println("Stop something"+ Thread.currentThread().getName());

        Future<String> stringFuture = asyncComponent.returnStringAsync();

        try {
            System.out.println("JOB'S DONE!: "+  stringFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("Waiting for future to be done!");
    }
}
