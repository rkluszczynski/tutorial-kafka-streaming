package io.github.rkluszczynski.kafka.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static java.util.Objects.isNull;

@Service
class MessageProducerService {
    private final KafkaTemplate<Integer, String> kafkaTemplate;

    @Value("${kafka.topic}")
    private String kafkaTopic;

    @Value("${kafka.message}")
    private String kafkaMessage;

    @Autowired
    public MessageProducerService(KafkaTemplate<Integer, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce() {
        final String message = (isNull(kafkaMessage) || "".equals(kafkaMessage))
                ? LocalDateTime.now().toString() : kafkaMessage;
        kafkaTemplate.send(kafkaTopic, message);
    }
}
