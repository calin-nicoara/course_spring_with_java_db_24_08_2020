package ro.esolacad.springcourse.di;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Lazy
public class LazyComponent {

    @PostConstruct
    public void init() {
        System.out.println("-------------------------------");
        System.out.println("CREATED LazyComponent");
        System.out.println("-------------------------------");
    }
}
