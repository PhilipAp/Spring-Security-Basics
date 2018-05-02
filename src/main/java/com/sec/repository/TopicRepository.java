package com.sec.repository;

import java.util.List;

import com.sec.entity.Topic;


public interface TopicRepository {

	Topic getTopicById(int topicId);

	List<Topic> getAllTopics();

	void addTopic(Topic topic);

	void updateTopic(Topic topic);
	
	void deleteTopic(int topicId);

	boolean topicExists(String title, String category);
	

}
