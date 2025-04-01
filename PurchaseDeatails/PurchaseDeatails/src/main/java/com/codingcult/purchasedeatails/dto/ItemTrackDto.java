package com.codingcult.purchasedeatails.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_track")
public class ItemTrackDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String trackId;        // Unique tracking ID for the item purchase
    private String userName;       // User who made the purchase
    private String item;           // Item purchased
    private double amount;         // Amount spent
    private String location;       // Where the purchase was made
    private LocalDateTime orderDate;  // Order date and time
    private LocalDateTime purchaseTime;  // Purchase time

    public ItemTrackDto() {}

    public ItemTrackDto(Long id, String trackId, String userName, String item, double amount, String location, LocalDateTime orderDate, LocalDateTime purchaseTime) {
        this.id = id;
        this.trackId = trackId;
        this.userName = userName;
        this.item = item;
        this.amount = amount;
        this.location = location;
        this.orderDate = orderDate;
        this.purchaseTime = purchaseTime;
    }

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTrackId() { return trackId; }
    public void setTrackId(String trackId) { this.trackId = trackId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

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
}
