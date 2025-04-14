package com.codingcult.purchasedetails.dto;


import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchase_timings")
public class PurchaseTimingDto implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String itemName;
    private String userMobile;

    private LocalDateTime purchaseTime;
    private boolean alertEnabled;
    private boolean isActive = true;
	public PurchaseTimingDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PurchaseTimingDto(int id, String itemName, String userMobile, LocalDateTime purchaseTime,
			boolean alertEnabled, boolean isActive) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.userMobile = userMobile;
		this.purchaseTime = purchaseTime;
		this.alertEnabled = alertEnabled;
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "PurchaseTimingDto [id=" + id + ", itemName=" + itemName + ", userMobile=" + userMobile
				+ ", purchaseTime=" + purchaseTime + ", alertEnabled=" + alertEnabled + ", isActive=" + isActive + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public LocalDateTime getPurchaseTime() {
		return purchaseTime;
	}
	public void setPurchaseTime(LocalDateTime purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
	public boolean isAlertEnabled() {
		return alertEnabled;
	}
	public void setAlertEnabled(boolean alertEnabled) {
		this.alertEnabled = alertEnabled;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

  
}
