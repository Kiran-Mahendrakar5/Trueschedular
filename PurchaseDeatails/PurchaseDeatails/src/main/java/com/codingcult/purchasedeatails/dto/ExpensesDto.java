package com.codingcult.purchasedeatails.dto;


import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "expenses")
public class ExpensesDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;    // User who spent the money
    private String item;        // Item purchased
    private double amount;      // Amount spent on the item
    private LocalDateTime spendTime; // Time when the purchase was made

    // Default constructor
    public ExpensesDto() {}

    // Constructor with fields
    public ExpensesDto(Long id, String userName, String item, double amount, LocalDateTime spendTime) {
        this.id = id;
        this.userName = userName;
        this.item = item;
        this.amount = amount;
        this.spendTime = spendTime;
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

    public LocalDateTime getSpendTime() { return spendTime; }
    public void setSpendTime(LocalDateTime spendTime) { this.spendTime = spendTime; }
}
