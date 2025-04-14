package com.codingcult.purchasedetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.codingcult.purchasedetails","com.codingcult.purchasedetails.controller"})
public class PurchaseDetailsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PurchaseDetailsApplication.class, args);
    }

}
