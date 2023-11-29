package com.example.springbootrabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.springbootrabbitmq.dto.User;

@Service
public class RabbitMQJsonConsumer {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(RabbitMQJsonConsumer.class);
	
	
	
	@RabbitListener(queues = {"${rabbitmq.jsonQueue.name}"})
	public void consumeJsonMessage(User user) {
		LOGGER.info(String.format("Message Recieved from RabbitMq -> %s", user.toString()));
	}

}
