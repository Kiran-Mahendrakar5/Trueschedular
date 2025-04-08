package com.codingcult.activitylog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients(basePackages = "com.codingcult.activitylog.feign")
@ComponentScan(basePackages = {"com.codingcult.activitylog", "com.codingcult.activitylogcontroller"})
@SpringBootApplication
public class ActivityLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityLogApplication.class, args);
	}

	 @Bean
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
}
