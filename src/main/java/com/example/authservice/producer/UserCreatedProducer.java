package com.example.authservice.producer;

import com.example.authservice.api.UserCreatedEvent;
import com.example.authservice.exception.ConvertException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserCreatedProducer {
    private final ObjectMapper mapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(UserCreatedEvent message){
        Assert.notNull(message, "message mustn't be null");
        try {
            kafkaTemplate.send("user-created", mapper.writeValueAsString(message));
        } catch (JsonProcessingException e) {
            log.error("Error convert and send product reserved event: {}", message, e);
            throw new ConvertException(e.getMessage());
        }
    }
}
