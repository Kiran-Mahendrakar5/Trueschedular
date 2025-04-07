package com.codingcult.purchasedeatails.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shops")
public class ShopsDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shopName;
    private String location;
    private String userName;
    private String item;
    private String phoneNumber;
    private boolean isActive = true;

    public ShopsDto() {}

    public ShopsDto(Long id, String shopName, String location, String userName, String item, String phoneNumber, boolean isActive) {
        this.id = id;
        this.shopName = shopName;
        this.location = location;
        this.userName = userName;
        this.item = item;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
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

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}
