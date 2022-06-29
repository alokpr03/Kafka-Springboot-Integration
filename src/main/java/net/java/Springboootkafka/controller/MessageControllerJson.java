package net.java.Springboootkafka.controller;
import net.java.Springboootkafka.kafka.KafkaProduseJson;
import net.java.Springboootkafka.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class MessageControllerJson {
    private KafkaProduseJson kafkaProduseJson;

    public MessageControllerJson(KafkaProduseJson kafkaProduseJson) {
        this.kafkaProduseJson = kafkaProduseJson;
    }
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user)
    {
        kafkaProduseJson.sendMessage(user);
        return ResponseEntity.ok("Json Message sent to Kafka topic");
    }
}
