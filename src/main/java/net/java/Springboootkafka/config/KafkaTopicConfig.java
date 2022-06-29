package net.java.Springboootkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic javaTopic(){
        return TopicBuilder.name("myTopic")
                .build();
    }
    @Bean
    public NewTopic javaJsonTopic(){
        return TopicBuilder.name("myTopicJson")
                .build();
    }
}
