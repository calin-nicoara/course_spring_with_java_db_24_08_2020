package ro.esolacad.outsideofcourse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class OutsideConfiguration {

    @Bean
    public BigDecimal outsideDecimal() {
        return BigDecimal.TEN;
    }
}
