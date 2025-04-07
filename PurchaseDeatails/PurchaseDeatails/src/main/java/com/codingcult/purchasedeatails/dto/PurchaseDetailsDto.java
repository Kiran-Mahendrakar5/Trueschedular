package com.codingcult.purchasedeatails.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchase_details")
public class PurchaseDetailsDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String phoneNumber;
    private String item;
    private double amount;
    private String location;
    private LocalDateTime purchaseTime;
    private boolean isActive = true;

    public PurchaseDetailsDto() {}

    public PurchaseDetailsDto(Long id, String userName, String phoneNumber, String item,
                              double amount, String location, LocalDateTime purchaseTime, boolean isActive) {
        this.id = id;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.item = item;
        this.amount = amount;
        this.location = location;
        this.purchaseTime = purchaseTime;
        this.isActive = isActive;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDateTime getPurchaseTime() { return purchaseTime; }
    public void setPurchaseTime(LocalDateTime purchaseTime) { this.purchaseTime = purchaseTime; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}
