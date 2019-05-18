package com.fitness.effit.services.resources.food;

import java.net.UnknownHostException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fitness.effit.database.dto.Food;
import com.fitness.effit.database.service.EffitDatabaseService;
import com.google.common.base.Optional;

@Path("/food")
@Produces(MediaType.APPLICATION_JSON)
public class FoodResource {

	EffitDatabaseService dbService;
	
	public FoodResource() throws UnknownHostException {
		dbService = new EffitDatabaseService();
	}
	
	@GET
    public Food getFood(@QueryParam("id") Optional<Long> id) {
		Food food = dbService.getFoodById(id.get());
		return food;
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Food saveFood(@NotNull @Valid Food food) {
		
		dbService.storeFood(food);
		
		return food;
	}
	
}
