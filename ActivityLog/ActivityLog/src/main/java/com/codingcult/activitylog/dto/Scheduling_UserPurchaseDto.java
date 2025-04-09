	package com.codingcult.activitylog.dto;
	
	import java.io.Serializable;
	import java.time.LocalDateTime;
	
	import javax.persistence.*;
	
	@Entity
	@Table(name = "scheduling_userPurchasedto")
	public class Scheduling_UserPurchaseDto implements Serializable {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	
	    private String userName;
	    private String item;
	    private double amount;
	    private String location;
	    private LocalDateTime purchaseTime;
	
	    private boolean isActive = true; // 🔥 Added for soft delete
	
	    public Scheduling_UserPurchaseDto() {}
	
	    public Scheduling_UserPurchaseDto(Long id, String userName, String item, double amount, String location,
	                                      LocalDateTime purchaseTime) {
	        this.id = id;
	        this.userName = userName;
	        this.item = item;
	        this.amount = amount;
	        this.location = location;
	        this.purchaseTime = purchaseTime;
	        this.isActive = true;
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
	
	    public String getLocation() { return location; }
	
	    public void setLocation(String location) { this.location = location; }
	
	    public LocalDateTime getPurchaseTime() { return purchaseTime; }
	
	    public void setPurchaseTime(LocalDateTime purchaseTime) { this.purchaseTime = purchaseTime; }
	
	    public boolean isActive() { return isActive; }
	
	    public void setActive(boolean active) { isActive = active; }
	
	    @Override
	    public String toString() {
	        return "Scheduling_UserPurchaseDto [id=" + id + ", userName=" + userName + ", item=" + item + ", amount="
	                + amount + ", location=" + location + ", purchaseTime=" + purchaseTime + ", isActive=" + isActive + "]";
	    }
	}
	// post http://localhost:8098/api/purchases 
	//{"id":2,"userName":"Kiran","item":"Laptop","amount":45000.0,"location":"Bangalore","purchaseTime":"2025-04-07T15:00:00","active":true}