package com.codingcult.settingsconfig.dto;

import javax.persistence.*;

@Entity
@Table(name = "privacy_settings")
public class PrivacySettingsDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false, unique = true)
    private Long userId;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "data_encryption", nullable = false)
    private Boolean dataEncryptionEnabled;

    @Column(name = "permission_read", nullable = false)
    private Boolean canRead;

    @Column(name = "permission_write", nullable = false)
    private Boolean canWrite;

    @Column(name = "permission_delete", nullable = false)
    private Boolean canDelete;

    @Column(name = "is_active")
    private Boolean isActive = true;

    public PrivacySettingsDTO() {}

    public PrivacySettingsDTO(Long userId, String phoneNumber, Boolean dataEncryptionEnabled,
                              Boolean canRead, Boolean canWrite, Boolean canDelete) {
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.dataEncryptionEnabled = dataEncryptionEnabled;
        this.canRead = canRead;
        this.canWrite = canWrite;
        this.canDelete = canDelete;
        this.isActive = true;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public Boolean getDataEncryptionEnabled() { return dataEncryptionEnabled; }
    public void setDataEncryptionEnabled(Boolean dataEncryptionEnabled) { this.dataEncryptionEnabled = dataEncryptionEnabled; }

    public Boolean getCanRead() { return canRead; }
    public void setCanRead(Boolean canRead) { this.canRead = canRead; }

    public Boolean getCanWrite() { return canWrite; }
    public void setCanWrite(Boolean canWrite) { this.canWrite = canWrite; }

    public Boolean getCanDelete() { return canDelete; }
    public void setCanDelete(Boolean canDelete) { this.canDelete = canDelete; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
}