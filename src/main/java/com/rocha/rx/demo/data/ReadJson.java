package com.rocha.rx.demo.data;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReadJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Filter.class, new CustomFilterDeserializer());
		Gson gson = gsonBuilder.create();
		
		
		 try (FileReader reader = new FileReader("data.json")) {
	            Filter filter = gson.fromJson(reader, Filter.class);

	            System.out.println("The size of the list" + filter.getFilters().size());
	            // Accessing parsed data
	            filter.getFilters().forEach(data -> {
	                System.out.println("ID: " + data.getId());
	                System.out.println("Name: " + data.getName());
	                System.out.println("Type: " + data.getType());
	            });
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	}

}
