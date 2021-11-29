package com.bansal.moviecataloginfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.reactive.HttpComponentsClientHttpConnector;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class MoviecataloginfoApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		//Setting timeout
		HttpComponentsClientHttpRequestFactory clientHttpConnector =new HttpComponentsClientHttpRequestFactory();
		clientHttpConnector.setReadTimeout(3000);
		return new RestTemplate(clientHttpConnector);
	}
	public static void main(String[] args) {
		SpringApplication.run(MoviecataloginfoApplication.class, args);
	}

}
