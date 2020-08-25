package ro.esolacad.springcourse.di.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
//@Profile("!dev")
public class MainConfiguration implements GeneralConfiguration{

    @PostConstruct
    public void init() {
        System.out.println("-------------");
        System.out.println("-------------");
        System.out.println("I AM MAIN!");
        System.out.println("-------------");
        System.out.println("-------------");
    }

    @Override
    public String getLabel() {
        return "I AM MAIN!";
    }
}
