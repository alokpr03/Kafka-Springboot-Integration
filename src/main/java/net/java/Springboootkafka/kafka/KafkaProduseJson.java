package net.java.Springboootkafka.kafka;

import net.java.Springboootkafka.payload.User;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProduseJson {
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaProduseJson.class);

    private KafkaTemplate<String, User> kafkaTemplate;

    public KafkaProduseJson(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data)
    {
        LOGGER.info(String.format("Message sent %s",data.toString()));
        Message<User> message= MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "myTopicJson")
                .build();
        kafkaTemplate.send(message);
    }

}
