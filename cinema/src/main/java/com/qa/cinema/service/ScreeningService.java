package com.qa.cinema.service;


import java.util.HashMap;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.cinema.readjson.*;
import com.qa.cinema.util.JSONUtil;

import cinema.objects.Screening;

@ApplicationScoped
public class ScreeningService {
	makeMap map = new makeMap();
	private static final Logger LOGGER = Logger.getLogger(ScreeningService.class);	
	private HashMap<Integer, Object> screeningMap;
	private int ID;

	@Inject
	private JSONUtil util;
	
	public ScreeningService() {			
		initscreeningStore();
		LOGGER.info("THIS NEEDS TO APPEAR IN THE LOGGER");
	}

	public String getAllscreenings() {
		LOGGER.info("returns all screenings");
		return util.getJSONForObject(screeningMap.values());
	}

	public String addNewscreening(String screeningJson) {		
		ID = screeningMap.size();  
		ID++;
		Screening newscreening = util.getObjectForJSON(screeningJson, Screening.class);		
		LOGGER.info("In add screening method about to add to map");
		screeningMap.put(ID, newscreening);		
		LOGGER.info("In add screening method screening added to map");
		return screeningJson;
	}

	public String replacescreening(Integer screeningId, String updatedscreening) {
		LOGGER.info("replaces screening   "+screeningId+"   "+ updatedscreening);
		Screening newscreening = util.getObjectForJSON(updatedscreening, Screening.class);
		screeningMap.put(screeningId, newscreening);
		return updatedscreening;
	}

	public String deletescreening(Integer screeningId) {
		LOGGER.info("In delete screening method about to remove screening");
		screeningMap.remove(screeningId);
		LOGGER.info("In delete screening method screening removed");
		return "{\"message\": \"screening sucessfully removed\"}";
	}

	private void initscreeningStore() {
		LOGGER.info("initilises screening store");
		try {
			screeningMap = map.getMap("C:\\Screenings\\Administrator\\Desktop\\Tools\\JavaEEAngularBookstore-master\\bookstore58-complete\\screenings.json");
			LOGGER.info(screeningMap);
		} catch(NullPointerException e) {
			LOGGER.info("NULL FUCKING POINTER!!!");
		}
		//screeningMap = map.getMap("films.json");
		
	}
}
