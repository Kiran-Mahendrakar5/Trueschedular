package com.codingcult.purchasedeatails.dto;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shops")
public class ShopsDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;         // Shop ID
    private String shopName; // Shop Name
    private String location; // Shop Location
    private String userName; // User who made the purchase
    private String item;     // Item purchased in the shop

    // Default constructor
    public ShopsDto() {}

    // Constructor with all fields
    public ShopsDto(Long id, String shopName, String location, String userName, String item) {
        this.id = id;
        this.shopName = shopName;
        this.location = location;
        this.userName = userName;
        this.item = item;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getShopName() { return shopName; }
    public void setShopName(String shopName) { this.shopName = shopName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }
}

