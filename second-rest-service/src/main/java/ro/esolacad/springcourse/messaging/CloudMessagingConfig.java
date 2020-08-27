package ro.esolacad.springcourse.messaging;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableBinding(MessageChannels.class)
public class CloudMessagingConfig {
}
