package ro.esolacad.springcourse.messaging;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(MessageChannels.class)
public class CloudMessagingConfiguration {
}
