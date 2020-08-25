package ro.esolacad.springcourse.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")
class ConfigurationPropertiesTest {

    @Autowired
    private ConfigurationProperties configurationProperties;

    @Test
    public void testProperties() throws IOException {
        System.out.println(configurationProperties.getSingleValue());
        System.out.println(configurationProperties.getMultiple());
        List<String> stringList = Files.readAllLines(configurationProperties.getFileResource().getFile().toPath());
        System.out.println(stringList);
    }
}
