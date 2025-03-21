package com.codingcult.truescheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.codingcult.truescheduler", "com.codingcult.trueschedulercontroller"})


public class TrueSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrueSchedulerApplication.class, args);
	}

}
