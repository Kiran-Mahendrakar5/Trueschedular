package com.codingcult.notifyme.dto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "geo_based_stores")
public class GeoBasedDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String storeName;    // Name of the store
    private double latitude;     // Latitude coordinate
    private double longitude;    // Longitude coordinate
    private String address;      // Store address

    // Default constructor
    public GeoBasedDto() {}

    // Constructor with fields
    public GeoBasedDto(Long id, String storeName, double latitude, double longitude, String address) {
        this.id = id;
        this.storeName = storeName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStoreName() { return storeName; }
    public void setStoreName(String storeName) { this.storeName = storeName; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
