package com.kafka.streams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.streams.dto.Orders;
import com.kafka.streams.services.ProducerServices;

@RestController
public class ProducerController {

	@Autowired private ProducerServices vProducerServices;
	
	@PostMapping("/order")
	public void order(@RequestBody Orders pOrder) {
		vProducerServices.produceMessage(pOrder);
	}
}
