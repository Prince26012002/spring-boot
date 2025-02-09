package com.java.springBoot.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.java.springBoot.annotation.MyCustomComponent;

@Service
@MyCustomComponent
public class KafkaConsumer {

	@KafkaListener(topics = "my-topic", groupId = "test-group")
	public void listenMessage(String message) {
		System.out.println("Received Message : " + message);
	}

}
