package com.codingcult.truescheduler.dto;

import java.io.Serializable;

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

@Entity                      // Marks this as a JPA entity mapped to a table
@Table(name = "language")    // Defines the table name in the database
@Data                        // Lombok annotation to generate getters, setters, equals, hashCode, and toString
@AllArgsConstructor          // Generates constructor with all arguments
@NoArgsConstructor           // Generates no-arguments constructor
@Getter                      // Generates getter methods for all fields
@Setter                      // Generates setter methods for all fields
public class LanguageDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generates ID
    private Long id;

    private String languageName;   // Language name (e.g., English, French)
    private String country;         // Country where the language is spoken
    private boolean defaultLanguage; // Indicates if it's the default language
    
    

    public LanguageDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
    public String toString() {
        return "LanguageDto [id=" + id + ", languageName=" + languageName + 
               ", country=" + country + ", defaultLanguage=" + defaultLanguage + "]";
    }

	public LanguageDto(Long id, String languageName, String country, boolean defaultLanguage) {
		super();
		this.id = id;
		this.languageName = languageName;
		this.country = country;
		this.defaultLanguage = defaultLanguage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public boolean isDefaultLanguage() {
		return defaultLanguage;
	}

	public void setDefaultLanguage(boolean defaultLanguage) {
		this.defaultLanguage = defaultLanguage;
	}
    
    
    
}
