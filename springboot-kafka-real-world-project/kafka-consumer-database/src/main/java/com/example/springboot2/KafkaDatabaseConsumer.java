package com.example.springboot2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.springboot2.entity.WikimediaData;
import com.example.springboot2.repository.WikimediaDataRepository;

@Service
public class KafkaDatabaseConsumer {
	
	
	
	private static final Logger LOGGER=LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
	private WikimediaDataRepository dataRepository;
	
	
	
	public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository) {
		super();
		this.dataRepository = dataRepository;
	}



	@KafkaListener(
			topics = "${spring.kafka.topic.name}",
			groupId = "${spring.kafka.consumer.group-id}")
	public void consume(String eventMessage) {
		
		LOGGER.info(String.format("Event message recieved -> %s", eventMessage));
		
		WikimediaData wikimediaData= new WikimediaData();
		wikimediaData.setWikiEventData(eventMessage);
		dataRepository.save(wikimediaData);
		
	}

}
