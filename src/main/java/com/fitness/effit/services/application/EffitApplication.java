package com.fitness.effit.services.application;

import java.net.UnknownHostException;

import com.fitness.effit.services.configuration.EffitConfiguration;
import com.fitness.effit.services.resources.food.FoodResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class EffitApplication extends Application<EffitConfiguration> {

	public static void main(String[] args) throws Exception {
        new EffitApplication().run(args);
    }
	
	@Override
    public String getName() {
        return "Ef-FIt";
    }

    @Override
    public void initialize(Bootstrap<EffitConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(EffitConfiguration configuration, Environment environment) {
    	FoodResource foodResource = null;
		try {
			foodResource = new FoodResource();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
    	
    	environment.jersey().register(foodResource);
    }

}
