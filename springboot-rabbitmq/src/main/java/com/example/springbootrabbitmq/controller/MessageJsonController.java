package com.example.springbootrabbitmq.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrabbitmq.dto.User;
import com.example.springbootrabbitmq.publisher.RabbitMQJsonProducer;

@RestController
@RequestMapping("api/v1")
public class MessageJsonController {
	
	private RabbitMQJsonProducer rabbitMQJsonProducer;

	public MessageJsonController(RabbitMQJsonProducer rabbitMQJsonProducer) {
		super();
		this.rabbitMQJsonProducer = rabbitMQJsonProducer;
	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestBody User user) {
		rabbitMQJsonProducer.sendJsonMessage(user);
		return ResponseEntity.ok("Json message sent to the RabbitMq");
		
	}

}
