package com.codingcult.purchasedeatails.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "purchase_details")
public class PurchaseDetailsDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String item;
    private double amount;
    private String location;
    private LocalDateTime purchaseTime;

    public PurchaseDetailsDto() {}

    public PurchaseDetailsDto(Long id, String userName, String item, double amount, String location, LocalDateTime purchaseTime) {
        this.id = id;
        this.userName = userName;
        this.item = item;
        this.amount = amount;
        this.location = location;
        this.purchaseTime = purchaseTime;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public LocalDateTime getPurchaseTime() { return purchaseTime; }
    public void setPurchaseTime(LocalDateTime purchaseTime) { this.purchaseTime = purchaseTime; }
}
