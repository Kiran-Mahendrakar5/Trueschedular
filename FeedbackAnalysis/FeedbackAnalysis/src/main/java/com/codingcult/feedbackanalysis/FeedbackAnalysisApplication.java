package com.codingcult.feedbackanalysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.codingcult.feedbackanalysis", "com.codingcult.FeedbackController"})
@SpringBootApplication
public class FeedbackAnalysisApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedbackAnalysisApplication.class, args);
	}

}
