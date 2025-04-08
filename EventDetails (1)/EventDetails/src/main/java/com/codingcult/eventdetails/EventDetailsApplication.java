package com.codingcult.eventdetails;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

@ComponentScan(basePackages = {"com.codingcult.eventdetails", "com.codingcult.eventdetails.controller"})
public class EventDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventDetailsApplication.class, args);
	}
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}