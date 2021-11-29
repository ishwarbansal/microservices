package com.bansal.movieinfo.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bansal.movieinfo.models.Movie;

@RestController
@RequestMapping("/movie")
public class MovieResource {

	@RequestMapping("/{movieId}")
	public Movie getCatalogItem(@PathVariable("movieId") String movieId){
		return new Movie("Transformer", movieId);
	}

}
