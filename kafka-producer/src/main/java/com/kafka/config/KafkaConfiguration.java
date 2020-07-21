package com.kafka.config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfiguration {

    private final Logger logger = LoggerFactory.getLogger(KafkaConfiguration.class);

    @KafkaListener(topics = "my-topic")
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
        logger.info("------------------------------------------------------------------------");
        logger.info(cr.toString());
        logger.info("------------------------------------------------------------------------");
    }

}
