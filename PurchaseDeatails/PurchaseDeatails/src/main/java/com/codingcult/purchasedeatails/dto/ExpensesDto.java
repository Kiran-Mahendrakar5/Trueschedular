package com.codingcult.purchasedeatails.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses")
public class ExpensesDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String item;
    private double amount;
    private LocalDateTime spendTime;

    private String phoneNumber;   // Added phone number
    private boolean isActive = true;  // Soft delete flag

    public ExpensesDto() {}

    public ExpensesDto(Long id, String userName, String item, double amount,
                       LocalDateTime spendTime, String phoneNumber, boolean isActive) {
        this.id = id;
        this.userName = userName;
        this.item = item;
        this.amount = amount;
        this.spendTime = spendTime;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
    }

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

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}
