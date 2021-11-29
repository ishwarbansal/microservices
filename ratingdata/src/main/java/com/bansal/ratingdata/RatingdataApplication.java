package com.bansal.ratingdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RatingdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingdataApplication.class, args);
	}

}
