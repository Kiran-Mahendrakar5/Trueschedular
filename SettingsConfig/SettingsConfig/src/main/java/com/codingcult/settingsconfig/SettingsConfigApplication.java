package com.codingcult.settingsconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan(basePackages = {"com.codingcult.settingsconfig", "com.codingcult.settingsconfig.controller"})
public class SettingsConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SettingsConfigApplication.class, args);
	}

}
