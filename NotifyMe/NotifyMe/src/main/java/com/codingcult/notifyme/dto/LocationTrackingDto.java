package com.codingcult.notifyme.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "location_tracking")
public class LocationTrackingDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;              // User making the purchase
    private String item;                  // Purchased item
    private double amount;                // Amount spent
    private String latitude;              // Latitude coordinate
    private String longitude;             // Longitude coordinate
    private LocalDateTime purchaseTime;   // Time of purchase

    @Transient  // Not stored in DB
    private String locationUrl;           // Google Maps link

    public String getLocationUrl() {
        return "https://www.google.com/maps?q=" + latitude + "," + longitude;
    }

	public LocationTrackingDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocationTrackingDto(Long id, String userName, String item, double amount, String latitude, String longitude,
			LocalDateTime purchaseTime, String locationUrl) {
		super();
		this.id = id;
		this.userName = userName;
		this.item = item;
		this.amount = amount;
		this.latitude = latitude;
		this.longitude = longitude;
		this.purchaseTime = purchaseTime;
		this.locationUrl = locationUrl;
	}

	@Override
	public String toString() {
		return "LocationTrackingDto [id=" + id + ", userName=" + userName + ", item=" + item + ", amount=" + amount
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", purchaseTime=" + purchaseTime
				+ ", locationUrl=" + locationUrl + "]";
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

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public LocalDateTime getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(LocalDateTime purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	public void setLocationUrl(String locationUrl) {
		this.locationUrl = locationUrl;
	}

    // Getters and setters...


}
