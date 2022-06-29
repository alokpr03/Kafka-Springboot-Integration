package net.java.Springboootkafka.kafka;

import net.java.Springboootkafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumJson {
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaConsumJson.class);
    @KafkaListener(topics = "myTopicJson")
    public void  consume(User user)
    {
        LOGGER.info(String.format("Json Message Received %s",user.toString()));
    }
}
