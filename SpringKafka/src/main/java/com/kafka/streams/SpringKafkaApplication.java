package com.kafka.streams;

import java.util.function.Consumer;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import jdk.internal.org.jline.utils.Log;

@SpringBootApplication
public class SpringKafkaApplication {

	
	private static final Logger log = LoggerFactory.getLogger(SpringKafkaApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaApplication.class, args);
	}
	
	@Bean
	public Function<String, String> toUpperCase() {
		return value-> value.toUpperCase();
	}

	@Bean
	public Function<String, String> data() {
		return value-> value;
	}
	
	@Bean
	public Consumer<String> consumer() {
		return value-> log.info("value is {}", value);
	}
	
}
