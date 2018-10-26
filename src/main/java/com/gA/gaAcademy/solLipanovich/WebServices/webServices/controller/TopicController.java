package com.gA.gaAcademy.solLipanovich.WebServices.webServices.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	// return new ResponseEntity<TopicResponse> (new
	// TopicResponse(createTopic),httpsStatus.ACCEPTED);
	// }

	@PostMapping("/topic")
	public Topic createTopic(@RequestBody Topic inputTopic) {
		Topic topic = topicService.createTopic(inputTopic);
		return topic;
	}

	@GetMapping("/topic")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}

	@GetMapping("/topic/{id}") // se captura lo que se pone entre llaves
	public Topic getTopicById(@PathVariable int id) { // el path variable captura lo que esta en la URL como parametro
		return topicService.getTopicById(id);
	}

	@PutMapping("/topic/{id}")
	public Topic updateTopic(@PathVariable int id, @RequestBody Topic updateTopic) {
		return topicService.updateTopic(id, updateTopic);
	}

	@DeleteMapping("/topic/{id}")
	public ResponseEntity<?> deleteTopic(@PathVariable int id) { // deberiamos devolver ResponseEntity<?> en todos los
																	// demas metodos, para poder arrojar mensajes tmb en
																	// caso de errores o exitos
		int idOfDeletedTopic = topicService.deleteTopicFisico(id);
		String message = "El topic: " + idOfDeletedTopic + "fue borrado exitosamente";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@DeleteMapping("/topic/logic/{id}")
	public ResponseEntity<?> deleteTopicLogic(@PathVariable int id){
		int isDeleted = topicService.deleteLogicTopic(id);
		
		if(isDeleted>0) {
			String message = "El topic: " + id + " fue borrado logicamente de manera exitosa";
			return new ResponseEntity<String>(message,HttpStatus.OK);
		}
		else {
			String errorMessage = "No se pudo borrar el topic con id: " + id ; 
			return new ResponseEntity<String>(errorMessage, HttpStatus.NOT_FOUND);
		}
		
		
	}

}
