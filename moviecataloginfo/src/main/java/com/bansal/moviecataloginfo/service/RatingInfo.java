package com.bansal.moviecataloginfo.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import models.Rating;
import models.UserRating;

@Service
public class RatingInfo {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod ="getFallbackCatalogRatings", commandProperties = {
			@HystrixProperty (name="execution.isolation.thread.timeoutInMilliseconds", value="2000"),
			@HystrixProperty (name="circuitBreaker.requestVolumeThreshol", value="5"),
			@HystrixProperty (name="circuitBreaker.errorThresholdPercentage", value="50"),
			@HystrixProperty (name="circuitBreaker.sleepWindowInMilliseconds", value="5000")
	})
	public UserRating getUserRatings(String userId) {
		return restTemplate.getForObject("http://RATING-INFO-SERVICE/ratingdata/users/"+userId, UserRating.class);
	}
	
	public UserRating getFallbackCatalogRatings(String userId){
		UserRating userRating = new UserRating();
		userRating.setUserId(userId);
		userRating.setRatings(Arrays.asList(new Rating("No Rating", 0)));
		return userRating;
	}
	
}
