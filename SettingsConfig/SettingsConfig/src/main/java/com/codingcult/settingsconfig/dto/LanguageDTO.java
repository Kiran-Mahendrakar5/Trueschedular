package com.codingcult.settingsconfig.dto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "languages")
public class LanguageDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Language name cannot be blank")
    @Column(name = "language_name", nullable = false, unique = true)
    private String languageName;

    @NotBlank(message = "Language code cannot be blank")
    @Column(name = "language_code", nullable = false, unique = true)
    private String languageCode; // e.g., "en", "fr", "es"

    @Column(name = "is_default")
    private boolean isDefault;

    public LanguageDTO() {}

    public LanguageDTO(String languageName, String languageCode, boolean isDefault) {
        this.languageName = languageName;
        this.languageCode = languageCode;
        this.isDefault = isDefault;
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

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }
}
