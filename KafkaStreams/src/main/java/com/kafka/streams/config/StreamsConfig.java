package com.kafka.streams.config;

import java.util.HashMap;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.kafka.streams.dto.Orders;

@Configuration
public class StreamsConfig {

	private String vBootStrapServer= "127.0.0.1:9092";
	
	@Bean
	public KafkaTemplate<String, Orders> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

	public ProducerFactory<String, Orders> producerFactory() {
		HashMap<String, Object> vHmConfig= new HashMap<>();
		vHmConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, vBootStrapServer);
		vHmConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		vHmConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(vHmConfig);
	}
	
}
