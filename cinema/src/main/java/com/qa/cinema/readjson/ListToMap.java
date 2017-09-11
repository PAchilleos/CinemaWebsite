package com.qa.cinema.readjson;

import java.util.HashMap;
import java.util.List;

import cinema.objects.Movie;

public class ListToMap {
	
	public HashMap<Integer,Object> convertToMap(List<Object> list){
		HashMap<Integer,Object> map = new HashMap<Integer,Object>();
		for(int i=1;i<=list.size();i++){
			map.put(i, list.get(i-1));
		}
		return map;
	}

}
