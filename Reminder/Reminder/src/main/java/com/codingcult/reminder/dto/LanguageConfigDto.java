package com.codingcult.reminder.dto;

import javax.persistence.*;

@Entity
@Table(name = "language_config")
public class LanguageConfigDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userPhoneNumber;
    private String preferredLanguage; // e.g., en, kn, hi
    private String popupTone;         // e.g., chime, alarm
    private String popupStyle;        // e.g., classic, modern

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public String getPopupTone() {
        return popupTone;
    }

    public void setPopupTone(String popupTone) {
        this.popupTone = popupTone;
    }

    public String getPopupStyle() {
        return popupStyle;
    }

    public void setPopupStyle(String popupStyle) {
        this.popupStyle = popupStyle;
    }

	public LanguageConfigDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LanguageConfigDto(int id, String userPhoneNumber, String preferredLanguage, String popupTone,
			String popupStyle) {
		super();
		this.id = id;
		this.userPhoneNumber = userPhoneNumber;
		this.preferredLanguage = preferredLanguage;
		this.popupTone = popupTone;
		this.popupStyle = popupStyle;
	}

	@Override
	public String toString() {
		return "LanguageConfigDto [id=" + id + ", userPhoneNumber=" + userPhoneNumber + ", preferredLanguage="
				+ preferredLanguage + ", popupTone=" + popupTone + ", popupStyle=" + popupStyle + "]";
	}
    
    
}
