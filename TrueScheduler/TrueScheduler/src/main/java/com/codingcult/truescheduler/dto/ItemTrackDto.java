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
@Table(name = "item_track")
public class ItemTrackDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;               // Name of the item ordered
    private LocalDateTime orderTime;       // Time of order
    private String status;                 // Order status (Pending, Shipped, Delivered)
    private String trackId;                // Unique tracking ID
    private String location;               // Current location of the item

    @Override
    public String toString() {
        return "ItemTrackDto [id=" + id + ", itemName=" + itemName + ", orderTime=" + orderTime + 
               ", status=" + status + ", trackId=" + trackId + ", location=" + location + "]";
    }

	public ItemTrackDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemTrackDto(Long id, String itemName, LocalDateTime orderTime, String status, String trackId,
			String location) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.orderTime = orderTime;
		this.status = status;
		this.trackId = trackId;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public LocalDateTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTrackId() {
		return trackId;
	}

	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
    
    
}
