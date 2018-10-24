package com.gA.gaAcademy.solLipanovich.WebServices.webServices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gA.gaAcademy.solLipanovich.WebServices.webServices.entity.Topic;
import com.gA.gaAcademy.solLipanovich.WebServices.webServices.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	TopicRepository topicRespository;

	public Topic createTopic(Topic inputTopic) {
		Topic topic = topicRespository.save(inputTopic);
		return topic;
	}

	public List<Topic> getAllTopics() {
		List<Topic> allTopics =  topicRespository.findAll();
		return allTopics;
	}
	
	//necesito devolver una lista de los topics.
	//pedirselos al repository-> findAll

}
