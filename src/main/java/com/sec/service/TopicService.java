package com.sec.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.sec.entity.Topic;

public interface TopicService {
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	public abstract List<Topic> getAllTopics();
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	public abstract Topic getTopicById(Integer topicId);
	
	@Secured({"ROLE_ADMIN"})
	public abstract boolean addTopic(Topic topic);
	
	@Secured({"ROLE_ADMIN"})
	public abstract void updateTopid(Topic topic);
	
	@Secured({"ROLE_ADMIN"})
	public abstract void deleteTopic(Integer id);
	
	

}
