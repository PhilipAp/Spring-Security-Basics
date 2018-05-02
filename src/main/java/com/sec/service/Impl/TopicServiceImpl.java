package com.sec.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sec.entity.Topic;
import com.sec.repository.TopicRepository;
import com.sec.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService{
	
	@Autowired
	TopicRepository topicRepository; 

	@Override
	public List<Topic> getAllTopics() {
		return topicRepository.getAllTopics();
	}

	@Override
	public Topic getTopicById(Integer topicId) {
		return topicRepository.getTopicById(topicId);
	}

	@Override
	public boolean addTopic(Topic topic) {
		return false;
	}

	@Override
	public void updateTopid(Topic topic) {		
	}

	@Override
	public void deleteTopic(Integer id) {
	}

}
