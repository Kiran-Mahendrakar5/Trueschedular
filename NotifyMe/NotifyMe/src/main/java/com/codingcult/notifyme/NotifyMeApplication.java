package com.codingcult.notifyme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {"com.codingcult.notifyme", "com.codingcult.notifyme.controller"})
public class NotifyMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotifyMeApplication.class, args);
	}

}
