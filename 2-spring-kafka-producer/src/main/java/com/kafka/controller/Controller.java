package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	private KafkaTemplate<String, Object> template;

	@Value("${myapp.topic-name}")
	private String topicName;

	@PostMapping(path = "/send/{message}")
	public void sendFoo(@PathVariable String message) {
		this.template.send("first-topic", message);
	}

}
