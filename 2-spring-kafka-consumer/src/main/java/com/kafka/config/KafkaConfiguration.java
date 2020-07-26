package com.kafka.config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

@Configuration
public class KafkaConfiguration {

    private final Logger logger = LoggerFactory.getLogger(KafkaConfiguration.class);

    private final CountDownLatch latch = new CountDownLatch(3);

    @Value("${myapp.topic-name}")
    private String topicName;

    @KafkaListener(topics = "my-topic", groupId = "my-app-group")
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
        logger.info("------------------------------------------------------------------------");
        logger.info(cr.toString());
        logger.info(cr.value().toString());
        latch.countDown();
        logger.info("------------------------------------------------------------------------");
    }

}
