package com.codingcult.purchasedetails.dto;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "item_tracks")
public class ItemTrackDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String itemName;
    private String status; // "BOUGHT" or "PENDING"
    private String note;
    private String receipt;
    private String userMobile;
    private boolean isActive = true;

    public ItemTrackDto() {}

	public ItemTrackDto(int id, String itemName, String status, String note, String receipt, String userMobile,
			boolean isActive) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.status = status;
		this.note = note;
		this.receipt = receipt;
		this.userMobile = userMobile;
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "ItemTrackDto [id=" + id + ", itemName=" + itemName + ", status=" + status + ", note=" + note
				+ ", receipt=" + receipt + ", userMobile=" + userMobile + ", isActive=" + isActive + "]";
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

   
    
    
}