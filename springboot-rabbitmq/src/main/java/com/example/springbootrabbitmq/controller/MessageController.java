package com.example.springbootrabbitmq.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrabbitmq.publisher.RabbitMQProducer;

@RestController
@RequestMapping("api/v1")
public class MessageController {
	
	private RabbitMQProducer rabbitMQProducer;

	public MessageController(RabbitMQProducer rabbitMQProducer) {
		super();
		this.rabbitMQProducer = rabbitMQProducer;
	}
	
	
	//http://localhost:8080/api/v1/publish?message=hello world
	@GetMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
		
		rabbitMQProducer.sendMessage(message);
		return ResponseEntity.ok("Message sent to RabbitMQ");
		
	}

}
