package com.codingcult.settingsconfig.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "backups")
public class BackupDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "backup_type", nullable = false)
    private String backupType;

    @Column(name = "backup_date", nullable = false)
    private LocalDateTime backupDate;

    @Column(name = "size_in_mb", nullable = false)
    private double sizeInMB;

    @Column(name = "backup_status")
    private String backupStatus;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_active")
    private boolean isActive = true;

    public BackupDTO() {}

    public BackupDTO(String backupType, LocalDateTime backupDate, double sizeInMB, String backupStatus, String phoneNumber, boolean isActive) {
        this.backupType = backupType;
        this.backupDate = backupDate;
        this.sizeInMB = sizeInMB;
        this.backupStatus = backupStatus;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBackupType() { return backupType; }
    public void setBackupType(String backupType) { this.backupType = backupType; }

    public LocalDateTime getBackupDate() { return backupDate; }
    public void setBackupDate(LocalDateTime backupDate) { this.backupDate = backupDate; }

    public double getSizeInMB() { return sizeInMB; }
    public void setSizeInMB(double sizeInMB) { this.sizeInMB = sizeInMB; }

    public String getBackupStatus() { return backupStatus; }
    public void setBackupStatus(String backupStatus) { this.backupStatus = backupStatus; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}
