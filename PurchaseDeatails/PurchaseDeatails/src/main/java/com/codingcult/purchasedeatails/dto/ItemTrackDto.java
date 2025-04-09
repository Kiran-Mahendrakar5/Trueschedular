package com.codingcult.purchasedeatails.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "item_track")
public class ItemTrackDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trackId;
    private String userName;
    private String phoneNumber;
    private String item;
    private double amount;
    private String location;
    private LocalDateTime orderDate;
    private LocalDateTime purchaseTime;
    private boolean isActive = true;

    public ItemTrackDto() {}

    public ItemTrackDto(Long id, String trackId, String userName, String phoneNumber,
                        String item, double amount, String location,
                        LocalDateTime orderDate, LocalDateTime purchaseTime, boolean isActive) {
        this.id = id;
        this.trackId = trackId;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.item = item;
        this.amount = amount;
        this.location = location;
        this.orderDate = orderDate;
        this.purchaseTime = purchaseTime;
        this.isActive = isActive;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTrackId() { return trackId; }
    public void setTrackId(String trackId) { this.trackId = trackId; }

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

    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }

    public LocalDateTime getPurchaseTime() { return purchaseTime; }
    public void setPurchaseTime(LocalDateTime purchaseTime) { this.purchaseTime = purchaseTime; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}
