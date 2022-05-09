package com.kafka.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerController {

	@KafkaListener(topics = "testing", groupId = "group_1")
	public void consumeMessage(String pMessage) {
		System.out.println("Message: "+pMessage);
	}
}
