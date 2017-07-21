package io.github.rkluszczynski.kafka.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.LongStream;

import static java.util.Objects.isNull;

@Service
class MessageProducerService {
    private final KafkaTemplate<Integer, String> kafkaTemplate;

    @Value("${kafka.topic}")
    private String kafkaTopic;

    @Value("${kafka.message}")
    private String kafkaMessage;

    @Value("${kafka.count}")
    private Long kafkaCount;

    @Autowired
    public MessageProducerService(KafkaTemplate<Integer, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce() {
        LongStream
                .rangeClosed(1, kafkaCount)
                .forEach(this::sendOneMessage);
    }

    private void sendOneMessage(Long number) {
        try {
            Thread.sleep(200);
            kafkaTemplate.send(kafkaTopic, createMessage(number));
        } catch (InterruptedException e) {
            throw new RuntimeException("Producing interrupted", e);
        }
    }

    private String createMessage(Long number) {
        if (isNull(kafkaMessage) || "".equals(kafkaMessage)) {
            return String.format("message %d sent at %s", number, LocalDateTime.now().toString());
        }
        return String.format("%s {%d}", kafkaMessage, number);
    }
}
