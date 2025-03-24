package com.codingcult.truescheduler.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shop")
public class ShopDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shopName;
    private String location;
    private LocalDateTime purchaseTime;
    private String purchasedItem;
    private double amountSpent;
    private String paymentMethod;   // Cash, Card, UPI, etc.

    @Override
    public String toString() {
        return "ShopDto [id=" + id + ", shopName=" + shopName + 
               ", location=" + location + ", purchaseTime=" + purchaseTime + 
               ", purchasedItem=" + purchasedItem + 
               ", amountSpent=" + amountSpent + 
               ", paymentMethod=" + paymentMethod + "]";
    }

	public ShopDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShopDto(Long id, String shopName, String location, LocalDateTime purchaseTime, String purchasedItem,
			double amountSpent, String paymentMethod) {
		super();
		this.id = id;
		this.shopName = shopName;
		this.location = location;
		this.purchaseTime = purchaseTime;
		this.purchasedItem = purchasedItem;
		this.amountSpent = amountSpent;
		this.paymentMethod = paymentMethod;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
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

	public String getPurchasedItem() {
		return purchasedItem;
	}

	public void setPurchasedItem(String purchasedItem) {
		this.purchasedItem = purchasedItem;
	}

	public double getAmountSpent() {
		return amountSpent;
	}

	public void setAmountSpent(double amountSpent) {
		this.amountSpent = amountSpent;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
    
    
}
