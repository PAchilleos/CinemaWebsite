package com.qa.cinema.readjson;

import java.util.HashMap;
import java.util.List;

import cinema.objects.Movie;

public class makeMap {

	public HashMap<Integer,Object> getMap(String filePath) {
		ReadFromJson readJson = new ReadFromJson(); //can inject into app server
		ListToMap listToMap = new ListToMap(); //can inject into app server
		
		List<Object> movieList = readJson.getList(filePath);
		
		
		HashMap<Integer,Object> movieMap = listToMap.convertToMap(movieList);		
		return movieMap;
		

	}

}
