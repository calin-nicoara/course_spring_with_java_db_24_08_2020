package ro.esolacad.springcourse.di.profiles;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profile("dev")
@Primary
public class DevConfigurations implements GeneralConfiguration{

    @PostConstruct
    public void init() {
        System.out.println("-------------");
        System.out.println("-------------");
        System.out.println("I AM DEV!");
        System.out.println("-------------");
        System.out.println("-------------");
    }

    @Override
    public String getLabel() {
        return "I AM DEV!";
    }
}
