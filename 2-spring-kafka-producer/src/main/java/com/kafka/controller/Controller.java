package com.kafka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	private final Logger logger = LoggerFactory.getLogger(Controller.class);

	public static final String TOPIC = "my-topic";
	@Autowired
	private KafkaTemplate<String, Object> template;

	@Value("${myapp.topic-name}")
	private String topicName;

	@PostMapping(path = "/publish/{message}")
	public void sendFoo(@PathVariable String message) {
		logger.info("------------------------------------------------------------------------");
		logger.info("Sending Message: " + message);
		this.template.send(TOPIC, message);
		logger.info("------------------------------------------------------------------------");
	}

}
