package com.qa.cinema.readjson;

import java.util.HashMap;

import com.qa.cinema.util.JSONUtil;

import cinema.objects.Movie;

public class main {

	public static void main(String[] args) {
		makeMap map = new makeMap();
		
		HashMap<Integer,Object> movies = map.getMap("films.json");
		System.out.println(movies);
		
		JSONUtil util = new JSONUtil();
		String result =util.getJSONForObject(movies.values());		
		//Movie m = util.getObjectForJSON(result, Movie.class);
		System.out.println(result);
		

	}

}
