package com.bansal.ratingdata.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bansal.ratingdata.models.Rating;
import com.bansal.ratingdata.models.UserRating;

@RestController
@RequestMapping("/ratingdata")
public class RatingResource {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId){
		return	new Rating(movieId, 1);		
	}
	
	@RequestMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String movieId){
		UserRating userRating = new UserRating();
		List<Rating> ratings = Arrays.asList(
				new Rating("1234", 12),
				new Rating("2345", 14)
			);
		userRating.setRatings(ratings);
		return userRating;
	}

}
