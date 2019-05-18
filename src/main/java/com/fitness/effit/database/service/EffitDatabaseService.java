package com.fitness.effit.database.service;

import java.net.UnknownHostException;

import com.fitness.effit.database.dto.Food;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class EffitDatabaseService {

	private static final String DATABASE_NAME = "fitness";
	private static final String FOOD_DATABASE = "food";
	
	private MongoClient mongoClient;
	
	public EffitDatabaseService() throws UnknownHostException {
		mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
	}
	
	public Food getFoodById(long id) {

		DB database = mongoClient.getDB(DATABASE_NAME);
		DBCollection collection = database.getCollection(FOOD_DATABASE);
		
		DBObject query = new BasicDBObject("_id", id);
		DBCursor cursor = collection.find(query);
		
		if(cursor != null && cursor.count() > 0) {
			DBObject foodObject = cursor.one();
			String name = foodObject.get("name").toString();
			int calories = Integer.parseInt(foodObject.get("calories").toString());
			String servingSize = foodObject.get("servingSize").toString();
			
			return new Food(id, name, calories, servingSize);
			
		}
		
		return null;
	}
	
	public void storeFood(Food food) {
		DB database = mongoClient.getDB(DATABASE_NAME);
		DBCollection collection = database.getCollection(FOOD_DATABASE);
	    
		BasicDBObject dbObject = new BasicDBObject("_id", food.getId())
													.append("name", food.getName())
													.append("calories", food.getCalories())
													.append("servingSize", food.getServingSize());
		
		collection.insert(dbObject);
	}
	
	
}
