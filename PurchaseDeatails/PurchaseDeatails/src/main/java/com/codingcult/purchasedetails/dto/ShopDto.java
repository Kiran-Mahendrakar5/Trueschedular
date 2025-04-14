package com.codingcult.purchasedetails.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shops")
public class ShopDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String shopName;
    private String location;
    private String shopOwner;
    private boolean isActive = true;

    public ShopDto() {}

    public ShopDto(int id, String shopName, String location, String shopOwner, boolean isActive) {
        this.id = id;
        this.shopName = shopName;
        this.location = location;
        this.shopOwner = shopOwner;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "ShopDto{" +
                "id=" + id +
                ", shopName='" + shopName + '\'' +
                ", location='" + location + '\'' +
                ", shopOwner='" + shopOwner + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getShopName() { return shopName; }
    public void setShopName(String shopName) { this.shopName = shopName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getShopOwner() { return shopOwner; }
    public void setShopOwner(String shopOwner) { this.shopOwner = shopOwner; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}
