package com.codingcult.reminder.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bill_reminders")
public class BillReminderDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String billType; // Rent, Electricity, etc.
    private double amount;
    private LocalDateTime dueDate;
    private LocalDateTime alertTime;
    private boolean isActive = true;

    public BillReminderDto() {}

    public BillReminderDto(int id, String billType, double amount, LocalDateTime dueDate, LocalDateTime alertTime, boolean isActive) {
        this.id = id;
        this.billType = billType;
        this.amount = amount;
        this.dueDate = dueDate;
        this.alertTime = alertTime;
        this.isActive = isActive;
    }

    // Getters and Setters

    @Override
    public String toString() {
        return "BillReminderDto{" +
                "id=" + id +
                ", billType='" + billType + '\'' +
                ", amount=" + amount +
                ", dueDate=" + dueDate +
                ", alertTime=" + alertTime +
                ", isActive=" + isActive +
                '}';
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDateTime getAlertTime() {
		return alertTime;
	}

	public void setAlertTime(LocalDateTime alertTime) {
		this.alertTime = alertTime;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
    
    
}
