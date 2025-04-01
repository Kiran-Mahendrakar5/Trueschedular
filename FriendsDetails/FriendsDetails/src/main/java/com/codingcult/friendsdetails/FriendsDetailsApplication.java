package com.codingcult.friendsdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.codingcult.friendsdetails", "com.codingcult.friendsdetails.controller"})
public class FriendsDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FriendsDetailsApplication.class, args);
	}

}
