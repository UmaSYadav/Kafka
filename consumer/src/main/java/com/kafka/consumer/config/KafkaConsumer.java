package com.kafka.consumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.kafka.consumer.dto.User;

@EnableKafka
@Configuration
public class KafkaConsumer {

	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		Map<String, Object> vHmConfig= new HashMap<>();
		vHmConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		vHmConfig.put(ConsumerConfig.GROUP_ID_CONFIG, "group_1");
		vHmConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		vHmConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<String, String>(vHmConfig);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> factory() {
		ConcurrentKafkaListenerContainerFactory<String, String> vFactory= new ConcurrentKafkaListenerContainerFactory<>();
		vFactory.setConsumerFactory(consumerFactory());
		return vFactory;
	}
	
	@Bean
	public ConsumerFactory<String, User> consumerUserFactory() {
		Map<String, Object> vHmConfig= new HashMap<>();
		vHmConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		vHmConfig.put(ConsumerConfig.GROUP_ID_CONFIG, "group_2");
		vHmConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		vHmConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		vHmConfig.put(JsonDeserializer.TRUSTED_PACKAGES, "com.kafka.consumer.dto");
		return new DefaultKafkaConsumerFactory<String, User>(vHmConfig, new StringDeserializer(), new JsonDeserializer<>(User.class, false));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, User> userFactory() {
		ConcurrentKafkaListenerContainerFactory<String, User> vFactory= new ConcurrentKafkaListenerContainerFactory<>();
		vFactory.setConsumerFactory(consumerUserFactory());
		return vFactory;
	}
}
