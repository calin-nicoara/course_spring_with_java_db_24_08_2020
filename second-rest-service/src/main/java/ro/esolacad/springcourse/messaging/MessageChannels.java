package ro.esolacad.springcourse.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessageChannels {

    @Output
    MessageChannel productStockChannel();
}
