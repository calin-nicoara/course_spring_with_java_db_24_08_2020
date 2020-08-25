package ro.esolacad.springcourse.di;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ExcelFileWriter implements FinanceFileWriter{

    @PostConstruct
    public void init() {
        System.out.println("------------------");
        System.out.println("CREATED ExcelFileWriter");
        System.out.println("------------------");
    }

    public void writeFile(String content) {
        System.out.println("Write this in excel: " + content);
    }
}
