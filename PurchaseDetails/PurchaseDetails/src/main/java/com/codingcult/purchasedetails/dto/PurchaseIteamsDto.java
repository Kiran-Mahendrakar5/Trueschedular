package com.codingcult.purchasedetails.dto;

import javax.persistence.*;
import java.io.Serializable;

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

    @Transient
    private String locationTag;

    @ManyToOne
    @JoinColumn(name = "shopId", nullable = false)
    private ShopDto shop;

    public PurchaseIteamsDto() {}

	public PurchaseIteamsDto(int id, String itemName, double price, String storeName, String purchaseDate,
			String userMobile, String locationTag, ShopDto shop) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.price = price;
		this.storeName = storeName;
		this.purchaseDate = purchaseDate;
		this.userMobile = userMobile;
		this.locationTag = locationTag;
		this.shop = shop;
	}

	@Override
	public String toString() {
		return "PurchaseIteamsDto [id=" + id + ", itemName=" + itemName + ", price=" + price + ", storeName="
				+ storeName + ", purchaseDate=" + purchaseDate + ", userMobile=" + userMobile + ", locationTag="
				+ locationTag + ", shop=" + shop + "]";
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getLocationTag() {
		return locationTag;
	}

	public void setLocationTag(String locationTag) {
		this.locationTag = locationTag;
	}

	public ShopDto getShop() {
		return shop;
	}

	public void setShop(ShopDto shop) {
		this.shop = shop;
	}

   
    }