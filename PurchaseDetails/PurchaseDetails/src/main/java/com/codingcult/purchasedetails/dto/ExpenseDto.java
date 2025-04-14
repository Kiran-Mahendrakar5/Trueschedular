package com.codingcult.purchasedetails.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
public class ExpenseDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userMobile;
    private String itemName;
    private double amount;
    private String category;
    private LocalDate purchaseDate;
    private boolean isActive = true;

    public ExpenseDto() {}

    public ExpenseDto(int id, String userMobile, String itemName, double amount, String category, LocalDate purchaseDate, boolean isActive) {
        this.id = id;
        this.userMobile = userMobile;
        this.itemName = itemName;
        this.amount = amount;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "ExpenseDto{" +
                "id=" + id +
                ", userMobile='" + userMobile + '\'' +
                ", itemName='" + itemName + '\'' +
                ", amount=" + amount +
                ", category='" + category + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", isActive=" + isActive +
                '}';
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUserMobile() { return userMobile; }
    public void setUserMobile(String userMobile) { this.userMobile = userMobile; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public LocalDate getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}