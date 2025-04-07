package com.codingcult.activitylog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {"com.codingcult.activitylog", "com.codingcult.activitylogcontroller"})
@SpringBootApplication
public class ActivityLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityLogApplication.class, args);
	}

}
