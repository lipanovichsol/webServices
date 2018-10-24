package com.gA.gaAcademy.solLipanovich.WebServices.webServices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gA.gaAcademy.solLipanovich.WebServices.webServices.entity.Topic;
import com.gA.gaAcademy.solLipanovich.WebServices.webServices.service.TopicService;

@RestController
public class TopicController {

	@Autowired
	TopicService topicService;

	// @PostMapping("/topic"){
	// public ResponseEntity<?> createTopic(@RequestBody TopicRequest topicRequest)
	// // llego el json por parametro. ? porque puede ser creado o puede haber un
	// error
	// Topic createTopic = topicService.createTopic(topicRequest); //podria hacer un
	// get al ID que creo. Topic service solo crea un topic, y lo devuelve en forma
	// de topic-
	// return new ResponseEntity<TopicResponse>(new
	// TopicResponse(createTopic),httpsStatus.ACCEPTED);
	// }

	@PostMapping("/topic")
	public Topic createTopic(@RequestBody Topic inputTopic) {
		Topic topic = topicService.createTopic(inputTopic);
		return topic;
	}
}
