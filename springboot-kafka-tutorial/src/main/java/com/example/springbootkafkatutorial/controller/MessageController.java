package com.example.springbootkafkatutorial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootkafkatutorial.kafka.KafkaProducer;

@RestController
@RequestMapping("api/v1/kafka")
public class MessageController {
	
	private KafkaProducer kafkaProducer;
	
//	public void KafkaProducer(KafkaProducer kafkaProducer) {
//		this.kafkaProducer=kafkaProducer;
//	}
	public MessageController(KafkaProducer kafkaProducer) {
		super();
		this.kafkaProducer = kafkaProducer;
	}
	
	
	
	//http:localhost:8086/api/v1/kafka/publish?message=hello world
	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam("message") String message) {
		
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message sent to the topic");
		
		
	}



}
