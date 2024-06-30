package com.alessandro.strproducer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Log4j2
@RequiredArgsConstructor
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        String name = "name";
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("str-topic", message);

        future.whenComplete((result, ex) -> {
            if (ex != null) {
             log.error("Error sending message: {}", ex.getMessage());
             return;
            }
            log.info("Message sent successfully: {}", result.getProducerRecord().value());
            log.info("Partition {}, offset {}",
                    result.getRecordMetadata().partition(),
                    result.getRecordMetadata().offset());
        }
    );
    }
}
