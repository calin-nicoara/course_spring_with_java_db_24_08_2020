package ro.esolacad.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import ro.esolacad.outsideofcourse.OutsideConfiguration;
import ro.esolacad.springcourse.di.profiles.GeneralConfiguration;

@SpringBootApplication
@Import(OutsideConfiguration.class)
public class SpringDay1Application {


	public static void main(String[] args) {
		SpringApplication.run(SpringDay1Application.class, args);
	}

}
