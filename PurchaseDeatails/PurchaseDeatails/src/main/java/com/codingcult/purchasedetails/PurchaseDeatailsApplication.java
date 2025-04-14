package com.codingcult.purchasedetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.codingcult.purchasedetails") // or the specific subpackage
public class PurchaseDeatailsApplication {
    public static void main(String[] args) {
        SpringApplication.run(PurchaseDeatailsApplication.class, args);
    }
    
    
}

