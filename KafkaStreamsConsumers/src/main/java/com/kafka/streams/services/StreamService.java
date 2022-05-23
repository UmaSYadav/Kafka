package com.kafka.streams.services;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import com.kafka.streams.binding.StreamsBinding;
import com.kafka.streams.dto.Orders;

@EnableBinding(StreamsBinding.class)
@Service
public class StreamService {

	@StreamListener("order-input-channel")
	@SendTo("order-take-away-output-channel")
	public KStream<String, Orders> takeAway(KStream<String, Orders> pOrder) {
		return pOrder.filter((k, v)-> v.getsDelivery().equalsIgnoreCase("takeaway"));
	}
	
	@StreamListener("order-input-channel")
	@SendTo("order-homedelivery-output-channel")
	public KStream<String, Orders> homeDelivery(KStream<String, Orders> pOrder) {
		return pOrder.filter((k, v)-> v.getsDelivery().equalsIgnoreCase("homedelivery"));
	}
	
	
}
