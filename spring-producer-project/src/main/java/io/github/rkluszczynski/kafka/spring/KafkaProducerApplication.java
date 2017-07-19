package io.github.rkluszczynski.kafka.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerApplication implements CommandLineRunner {
    private final MessageProducerService producerService;

    @Autowired
    public KafkaProducerApplication(MessageProducerService producerService) {
        this.producerService = producerService;
    }

    @Override
    public void run(String... args) throws Exception {
        producerService.produce();
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }
}
