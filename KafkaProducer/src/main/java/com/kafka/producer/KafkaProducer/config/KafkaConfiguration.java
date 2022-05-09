package com.kafka.producer.KafkaProducer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.kafka.producer.KafkaProducer.dto.User;

@Configuration
public class KafkaConfiguration {

	
	@Bean
	public ProducerFactory<String, String> producerFactory() {
		Map<String, Object> vConfig= new HashMap<>();
		vConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		vConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		vConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return new DefaultKafkaProducerFactory<>(vConfig);
	}
	
	@Bean
	public KafkaTemplate<String, String> kafkaTemplate()  {
		return new KafkaTemplate<>(producerFactory());
	}
	
	
	@Bean
	public ProducerFactory<String, User> producerUserFactory() {
		Map<String, Object> vConfig= new HashMap<>();
		vConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		vConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		vConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(vConfig);
	}
	
	@Bean
	public KafkaTemplate<String, User> kafkaUserTemplate()  {
		return new KafkaTemplate<>(producerUserFactory());
	}
	
}
