package com.gA.gaAcademy.solLipanovich.WebServices.webServices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gA.gaAcademy.solLipanovich.WebServices.webServices.entity.Topic;
import com.gA.gaAcademy.solLipanovich.WebServices.webServices.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	TopicRepository topicRepository;

	public Topic createTopic(Topic inputTopic) {
		Topic topic = topicRepository.save(inputTopic);
		return topic;
	}

	public List<Topic> getAllTopics() {
		return topicRepository.findAll();
	}

	// necesito devolver una lista de los topics.
	// pedirselos al repository-> findAll

	public Topic getTopicById(int id) {
		return topicRepository.findById(id).get(); // optional es un contenedor simple. Puede contener o no variable
													// adentro.
		// Si tiene la variable con un punto get la obtengo, sino levanta una excepcion.
		// Por eso le hago GET
	}

	public Topic updateTopic(int id, Topic updateTopic) {
		Topic toUpdateTopic = getTopicById(id);
		if (updateTopic.getAuthorId() > 0)
			toUpdateTopic.setAuthorId(updateTopic.getAuthorId());
		if (updateTopic.getDatePost() != null)
			toUpdateTopic.setDatePost(updateTopic.getDatePost());
		if (updateTopic.getDescription() != null)
			toUpdateTopic.setDescription(updateTopic.getDescription());
		if (updateTopic.getTitle() != null)
			toUpdateTopic.setTitle(updateTopic.getTitle());
		toUpdateTopic = topicRepository.save(toUpdateTopic); 
		return toUpdateTopic;
	}

	public int deleteTopicFisico(int id) {
		topicRepository.deleteById(id);
		return id;
	}

	public int deleteLogicTopic(int id) {
		
		int toReturn=0;
		
		Topic topic = topicRepository.findById(id).get();
		if(!topic.isDeleted()) {
			topic.delete();
			toReturn=topic.getId();
			toReturn=topic.getId(); 
			topicRepository.save(topic);
		}
		return toReturn;
	}

}
