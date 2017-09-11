package com.qa.cinema.service;


import java.util.HashMap;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.cinema.readjson.*;
import com.qa.cinema.util.JSONUtil;

import cinema.objects.Movie;

@ApplicationScoped
public class MovieService {
	makeMap map = new makeMap();
	private static final Logger LOGGER = Logger.getLogger(MovieService.class);	
	private HashMap<Integer, Object> movieMap;
	private int ID;

	@Inject
	private JSONUtil util;
	
	public MovieService() {			
		initMovieStore();
		LOGGER.info("THIS NEEDS TO APPEAR IN THE LOGGER");
	}

	public String getAllMovies() {
		LOGGER.info("returns all movies");
		return util.getJSONForObject(movieMap.values());
	}

	public String addNewMovie(String movieJson) {		
		ID = movieMap.size();  
		ID++;
		Movie newMovie = util.getObjectForJSON(movieJson, Movie.class);		
		LOGGER.info("In add movie method about to add to map");
		movieMap.put(ID, newMovie);		
		LOGGER.info("In add movie method movie added to map");
		return movieJson;
	}

	public String replaceMovie(Integer movieId, String updatedMovie) {
		LOGGER.info("replaces movie   "+movieId+"   "+ updatedMovie);
		Movie newMovie = util.getObjectForJSON(updatedMovie, Movie.class);
		movieMap.put(movieId, newMovie);
		return updatedMovie;
	}

	public String deleteMovie(Integer movieId) {
		LOGGER.info("In delete movie method about to remove movie");
		movieMap.remove(movieId);
		LOGGER.info("In delete movie method movie removed");
		return "{\"message\": \"movie sucessfully removed\"}";
	}

	private void initMovieStore() {
		LOGGER.info("initilises movie store");
		try {
			movieMap = map.getMap("C:\\Users\\Administrator\\Desktop\\Tools\\JavaEEAngularBookstore-master\\bookstore58-complete\\films.json");
			LOGGER.info(movieMap);
		} catch(NullPointerException e) {
			LOGGER.info("NULL FUCKING POINTER!!!");
		}
		//movieMap = map.getMap("films.json");
		
	}
}
