package com.alessandro.strconsumer.listener;

import com.alessandro.strconsumer.custom.StrConsumerCustomListener;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {

    @SneakyThrows
    @StrConsumerCustomListener(groupId = "group-1")//modelo com anotação personalizada
    public void create(String message) {
        log.info("CREATE :: Message received: {}", message);
        throw new IllegalArgumentException("===>> Erro lançado...");
    }

    @KafkaListener(groupId = "group-1",
            topicPartitions = {
                @TopicPartition(topic = "str-topic", partitions = {"1"})
            }
            , containerFactory = "strContainerFactory")//modelo de configuração por método
    public void log(String message) {
        log.info("LOG :: Message received: {}", message);
    }

    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "validMessageContainerFactory")
    public void history(String message) {
        log.info("HISTORY :: Message received: {}", message);
    }

}
