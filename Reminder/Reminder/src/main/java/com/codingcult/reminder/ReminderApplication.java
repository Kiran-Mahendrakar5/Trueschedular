package com.codingcult.reminder;

import com.codingcult.reminder.service.ReminderNotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages = { "com.codingcult.reminder", "com.codingcult.reminder.controller" })
@SpringBootApplication

public class ReminderApplication {

	@Autowired
	private ReminderNotificationsService reminderNotificationsService;

	public static void main(String[] args) {
		SpringApplication.run(ReminderApplication.class, args);
	}

}
