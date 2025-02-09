package com.java.springBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.springBoot.annotation.MyCustomComponent;
import com.java.springBoot.kafka.service.KafkaProducer;

@RestController
@MyCustomComponent
@RequestMapping("/kafka")
public class KafkaController {

	private final KafkaProducer kafkaProducer;

	public KafkaController(KafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}

	@GetMapping("/send")
	public String sendMessage() {
		kafkaProducer.sendMessage("my-topic", "Hello, Welcome to world of Kafka");
		return "Message Produced to Kafka";
	}
}
