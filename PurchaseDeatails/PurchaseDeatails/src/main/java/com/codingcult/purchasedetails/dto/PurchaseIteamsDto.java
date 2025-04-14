package com.codingcult.purchasedetails.dto;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchase_items")
public class PurchaseIteamsDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String itemName;
    private double price;
    private String storeName;
    private String purchaseDate;
    private String userMobile;

    public PurchaseIteamsDto() {}

    public PurchaseIteamsDto(String itemName, double price, String storeName, String purchaseDate, String userMobile) {
        this.itemName = itemName;
        this.price = price;
        this.storeName = storeName;
        this.purchaseDate = purchaseDate;
        this.userMobile = userMobile;
    }

    // Getters and Setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getStoreName() { return storeName; }
    public void setStoreName(String storeName) { this.storeName = storeName; }

    public String getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(String purchaseDate) { this.purchaseDate = purchaseDate; }

    public String getUserMobile() { return userMobile; }
    public void setUserMobile(String userMobile) { this.userMobile = userMobile; }

    @Override
    public String toString() {
        return "PurchaseIteamsDto{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", storeName='" + storeName + '\'' +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", userMobile='" + userMobile + '\'' +
                '}';
    }
}
