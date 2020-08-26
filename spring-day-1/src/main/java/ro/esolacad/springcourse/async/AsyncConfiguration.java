package ro.esolacad.springcourse.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableAsync
public class AsyncConfiguration {

    @Bean("myExecutor")
    public Executor myExecutor() {
        return Executors.newFixedThreadPool(4);
    }
}
