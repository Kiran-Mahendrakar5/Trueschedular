package com.codingcult.purchasedeatails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.codingcult.purchasedeatails") // or the specific subpackage
public class PurchaseDeatailsApplication {
    public static void main(String[] args) {
        SpringApplication.run(PurchaseDeatailsApplication.class, args);
    }
}

