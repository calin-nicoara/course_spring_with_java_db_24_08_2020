package ro.esolacad.springcourse.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Primary
public class CsvFileWriter implements FinanceFileWriter{

//    @Value("${finance.file-writer.file-base-path}")
    private final String basePath;

    public CsvFileWriter(final @Value("${finance.file-writer.file-base-path}") String basePath) {
        this.basePath = basePath;
    }

    @PostConstruct
    public void init() {
        System.out.println("------------------");
        System.out.println("CREATED CsvFileWriter");
        System.out.println("------------------");
    }

    public void writeFile(String content) {
        System.out.println("This is the base path:" + basePath);
        System.out.println("Write this in csv: " + content);
    }
}
