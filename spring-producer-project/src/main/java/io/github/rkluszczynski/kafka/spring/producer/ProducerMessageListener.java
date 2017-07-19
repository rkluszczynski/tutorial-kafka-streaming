package io.github.rkluszczynski.kafka.spring.producer;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListenerAdapter;
import org.springframework.stereotype.Component;

@Component(value = "messageListener")
class ProducerMessageListener extends ProducerListenerAdapter<Integer, String> {

    @Override
    public void onSuccess(String topic, Integer partition, Integer key, String value, RecordMetadata recordMetadata) {
        super.onSuccess(topic, partition, key, value, recordMetadata);
    }

    @Override
    public void onError(String topic, Integer partition, Integer key, String value, Exception exception) {
        super.onError(topic, partition, key, value, exception);
    }
}
