package com.kafka.streams.binding;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;

import com.kafka.streams.dto.Orders;

public interface StreamsBinding {

	@Input("order-input-channel")
	KStream<String, Orders> inputStream();
	
	@Output("order-take-away-output-channel")
	KStream<String, Orders> takeAwayStream();
	
	@Output("order-homedelivery-output-channel")
	KStream<String, Orders> homeDeliveryStream();
}
