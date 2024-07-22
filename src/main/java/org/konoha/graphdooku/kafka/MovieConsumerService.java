package org.konoha.graphdooku.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MovieConsumerService {

//    @KafkaListener()
    void doSmth(@Payload String text) {
        log.info(text);
    }
}
