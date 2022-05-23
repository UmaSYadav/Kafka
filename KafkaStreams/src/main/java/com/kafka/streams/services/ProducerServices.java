package com.kafka.streams.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.kafka.streams.dto.Orders;

@Component
public class ProducerServices {

	private static final String TOPIC= "user";
	
	@Autowired KafkaTemplate<String, Orders> vKafkaTemplate;
	
	public void produceMessage(Orders pOrder) {
		vKafkaTemplate.send(TOPIC, UUID.randomUUID().toString(), pOrder);
	}
	
}
