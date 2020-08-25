package ro.esolacad.springcourse.di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ConfigurationProperties {

    @Value("${example-properties.single}")
    private String singleValue;

    @Value("${example-properties.multiple}")
    private Set<String> multiple;

    @Value("classpath:test-resource")
    private Resource fileResource;

    public String getSingleValue() {
        return singleValue;
    }

    public Set<String> getMultiple() {
        return multiple;
    }

    public Resource getFileResource() {
        return fileResource;
    }
}
