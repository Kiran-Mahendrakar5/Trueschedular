package com.codingcult.reminder.dto;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "recharge_alerts")
public class RechargeAlertDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String mobileNumber;
    private String operator;
    private LocalDate lastRechargeDate;
    private int validityPeriodDays; // e.g., 28 days
    private boolean alertSent;
    private boolean isActive = true;

    public RechargeAlertDto() {}

    // Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public LocalDate getLastRechargeDate() {
        return lastRechargeDate;
    }

    public void setLastRechargeDate(LocalDate lastRechargeDate) {
        this.lastRechargeDate = lastRechargeDate;
    }

    public int getValidityPeriodDays() {
        return validityPeriodDays;
    }

    public void setValidityPeriodDays(int validityPeriodDays) {
        this.validityPeriodDays = validityPeriodDays;
    }

    public boolean isAlertSent() {
        return alertSent;
    }

    public void setAlertSent(boolean alertSent) {
        this.alertSent = alertSent;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "RechargeAlertDto{" +
                "id=" + id +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", operator='" + operator + '\'' +
                ", lastRechargeDate=" + lastRechargeDate +
                ", validityPeriodDays=" + validityPeriodDays +
                ", alertSent=" + alertSent +
                ", isActive=" + isActive +
                '}';
    }
}
