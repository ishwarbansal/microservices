package com.bansal.moviecataloginfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import models.Movie;

@Service
public class MovieInfo {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod ="getFallbackCatalogMovie")
	public Movie getMovie(String movieId) {
		return restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movie/"+movieId, Movie.class);
	}
	
	public Movie getFallbackCatalogMovie(String movieId){
		return new Movie("No Movie", "0");
	}
}
