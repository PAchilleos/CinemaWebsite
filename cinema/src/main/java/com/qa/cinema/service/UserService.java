package com.qa.cinema.service;


import java.util.HashMap;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.cinema.readjson.*;
import com.qa.cinema.util.JSONUtil;

import cinema.objects.User;

@ApplicationScoped
public class UserService {
	makeMap map = new makeMap();
	private static final Logger LOGGER = Logger.getLogger(UserService.class);	
	private HashMap<Integer, Object> userMap;
	private int ID;

	@Inject
	private JSONUtil util;
	
	public UserService() {			
		inituserStore();
		LOGGER.info("THIS NEEDS TO APPEAR IN THE LOGGER");
	}

	public String getAllusers() {
		LOGGER.info("returns all users");
		return util.getJSONForObject(userMap.values());
	}

	public String addNewuser(String userJson) {		
		ID = userMap.size();  
		ID++;
		User newuser = util.getObjectForJSON(userJson, User.class);		
		LOGGER.info("In add user method about to add to map");
		userMap.put(ID, newuser);		
		LOGGER.info("In add user method user added to map");
		return userJson;
	}

	public String replaceuser(Integer userId, String updateduser) {
		LOGGER.info("replaces user   "+userId+"   "+ updateduser);
		User newuser = util.getObjectForJSON(updateduser, User.class);
		userMap.put(userId, newuser);
		return updateduser;
	}

	public String deleteuser(Integer userId) {
		LOGGER.info("In delete user method about to remove user");
		userMap.remove(userId);
		LOGGER.info("In delete user method user removed");
		return "{\"message\": \"user sucessfully removed\"}";
	}

	private void inituserStore() {
		LOGGER.info("initilises user store");
		try {
			userMap = map.getMap("C:\\Users\\Administrator\\Desktop\\Tools\\JavaEEAngularBookstore-master\\bookstore58-complete\\users.json");
			LOGGER.info(userMap);
		} catch(NullPointerException e) {
			LOGGER.info("NULL FUCKING POINTER!!!");
		}
		//userMap = map.getMap("films.json");
		
	}
}
