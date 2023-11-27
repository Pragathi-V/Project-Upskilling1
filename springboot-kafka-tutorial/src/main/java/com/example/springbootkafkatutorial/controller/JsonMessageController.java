package com.example.springbootkafkatutorial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootkafkatutorial.kafka.JsonKafkaProducer;
import com.example.springbootkafkatutorial.payload.User;

@RestController
@RequestMapping("kafkaJson")
public class JsonMessageController {

	private JsonKafkaProducer jsonKafkaProducer;

	
	
	public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
		super();
		this.jsonKafkaProducer = jsonKafkaProducer;
	}


	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody User user) {
		jsonKafkaProducer.sendMessage(user);
		return ResponseEntity.ok("Json message sent to kafka topic");
	}
}
