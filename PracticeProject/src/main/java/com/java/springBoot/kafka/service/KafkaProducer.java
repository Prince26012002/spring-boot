package com.java.springBoot.kafka.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.java.springBoot.annotation.MyCustomComponent;

@Service
@MyCustomComponent
public class KafkaProducer {

	private final KafkaTemplate<String, String> kafkaTemplate;

	public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String topic, String message) {
		kafkaTemplate.send(topic, message);
	}
}
