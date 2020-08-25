package ro.esolacad.springcourse.di.profiles;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("prod")
class GeneralConfigurationTest {

    @Autowired
    private GeneralConfiguration generalConfiguration;

    @Test
    public void testProfiles() {
        System.out.println(generalConfiguration.getLabel());
    }
}
