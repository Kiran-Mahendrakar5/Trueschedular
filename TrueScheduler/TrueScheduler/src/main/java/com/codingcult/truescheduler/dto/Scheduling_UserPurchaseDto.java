package com.codingcult.truescheduler.dto;


import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "scheduling_userPurchasedto")
public class Scheduling_UserPurchaseDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;        // User who made the purchase
    private String item;            // Item purchased
    private double amount;          // Amount spent
    private String location;        // Where the purchase was made
    private LocalDateTime purchaseTime;  // When the purchase was made

    @Override
    public String toString() {
        return "UserPurchase [id=" + id + ", userName=" + userName + 
               ", item=" + item + ", amount=" + amount + 
               ", location=" + location + ", purchaseTime=" + purchaseTime + "]";
    }

	public Scheduling_UserPurchaseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Scheduling_UserPurchaseDto(Long id, String userName, String item, double amount, String location,
			LocalDateTime purchaseTime) {
		super();
		this.id = id;
		this.userName = userName;
		this.item = item;
		this.amount = amount;
		this.location = location;
		this.purchaseTime = purchaseTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDateTime getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(LocalDateTime purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
    
    
}

