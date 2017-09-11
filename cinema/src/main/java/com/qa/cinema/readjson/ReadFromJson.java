package com.qa.cinema.readjson;


import java.io.FileReader;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import cinema.objects.Movie;
 
public class ReadFromJson {
 
    public List<Object> getList(String filePath){
        ObjectMapper mapper = new ObjectMapper();  
         
 
        /**
         * Read JSON from a file into a Map
         */
        try {
        	List<Object> list = mapper.readValue(new FileReader(filePath), new TypeReference<List<Object>>() {
            });
 
           return list;
            
 
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}
 
    
}