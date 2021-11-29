package com.bansal.moviecataloginfo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bansal.moviecataloginfo.service.MovieInfo;
import com.bansal.moviecataloginfo.service.RatingInfo;

import models.CataLogItem;
import models.Movie;
import models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogueResource {

	@Autowired
	MovieInfo movieInfo;
	
	@Autowired
	RatingInfo ratingInfo;
	
	@RequestMapping("/{userId}")
	public List<CataLogItem> getCatalogItem(@PathVariable("userId") String userId){
		
		UserRating userRating = ratingInfo.getUserRatings(userId);
		
		return userRating.getRatings().stream().map(rating -> {
			Movie movie = movieInfo.getMovie(rating.getMovieId());
			return new CataLogItem(movie.getName(), "Description of "+movie.getName(), rating.getRating());
		}).collect(Collectors.toList());
		
				
	}
}
