package com.kafka.basic;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class ProducerDemoWithKey {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final Logger log = LoggerFactory.getLogger(ProducerDemoWithKey.class);

        String bootstrapServer = "127.0.0.1:2181";

        //Create producer properties
        Properties props = new Properties();
        props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

        //Create kafka producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props );

        for (int i = 0; i < 10; i++) {

            //Create producer record
            String topic = "first_topic";
            String value = "hello world" + Integer.toString(i);
            String key= "id_" + Integer.toString(i);
            ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, key, value);

            //Send data - asynchronous
            producer.send(record, new Callback() {
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    //execute every time record is successfully sent or exception is thrown
                    if (e==null){
                        //record was successfully sent
                        log.info("Received new Metadata \n"+
                                "Topic:"+ recordMetadata.topic() + "\n"+
                                "Partition:"+ recordMetadata.partition() + "\n"+
                                "Offset:"+ recordMetadata.offset() + "\n"+
                                "Timestamp:"+ recordMetadata.timestamp() + "\n");
                    }else {
                        log.error("Error while producing", e);
                    }
                }
            }).get(); //block the send() to make it synchronous - dont do this in prod
        }
        producer.flush();
        producer.close();

    }
}
