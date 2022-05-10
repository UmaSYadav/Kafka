package com.kafka.producer.KafkaProducer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.producer.KafkaProducer.dto.User;

@RestController
@RequestMapping("kafka")
public class UserKafkaController {

	@Autowired KafkaTemplate<String, String> vKafkaTemplate;
	@Autowired KafkaTemplate<String, User> vKafkaUserTemplate;
	@Autowired KafkaTemplate<String, User> vKafkaUserXmlTemplate;
	
	private static final String TOPIC= "testing";
	private static final String TOPIC_JSON= "testing_json";
	
	@GetMapping("/publish/{message}")
	public String post(@PathVariable("message") String pMessage) {
		vKafkaTemplate.send(TOPIC, pMessage);
		return "String Message Published Successfully";
	}
	
	@GetMapping("/publish/user/{name}")
	public String postUser(@PathVariable("name") String pName) {
		vKafkaUserTemplate.send(TOPIC_JSON, new User(pName, "Technical", 12000));
		return "JSON  Message Published Successfully";
	}
	
	@GetMapping("/publish/user/xml/{name}")
	public String postUserXml(@PathVariable("name") String pName) {
		vKafkaUserXmlTemplate.send(TOPIC, new User(pName, "Technical", 12000));
		return "Published Successfully";
	}
}
