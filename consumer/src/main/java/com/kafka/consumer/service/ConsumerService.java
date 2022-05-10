package com.kafka.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.kafka.consumer.dto.User;

@Service
public class ConsumerService {

	@KafkaListener(topics = "testing", groupId = "group_1")
	public void consumeMessage(String pMessage) {
		System.out.println("String Message: "+pMessage);
	}
	
	@KafkaListener(topics = "testing_json", groupId = "group_2", containerFactory = "userFactory")
	public void consumeMessageUser(User pUser) {
		System.out.println("Json Message: "+pUser);
	}
}
