package com.codingcult.reminder.dto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "reminder_notifications")
public class ReminderNotificationsDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "User email cannot be blank")
    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @NotBlank(message = "Notification type cannot be blank")
    @Column(name = "notification_type", nullable = false)
    private String notificationType;  // Example: "Purchase Reminder", "Reorder Alert"

    @NotBlank(message = "Product name cannot be blank")
    @Column(name = "product_name", nullable = false)
    private String productName;

    @NotNull(message = "Reminder date cannot be null")
    @Column(name = "reminder_date", nullable = false)
    private LocalDateTime reminderDate;

    @Column(name = "status")
    private String status = "PENDING";  // Default status is pending

    public ReminderNotificationsDTO() {
        super();
    }

    public ReminderNotificationsDTO(Long id, String userEmail, String notificationType, String productName, LocalDateTime reminderDate, String status) {
        this.id = id;
        this.userEmail = userEmail;
        this.notificationType = notificationType;
        this.productName = productName;
        this.reminderDate = reminderDate;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReminderNotificationsDTO [id=" + id + ", userEmail=" + userEmail + ", notificationType=" + notificationType +
                ", productName=" + productName + ", reminderDate=" + reminderDate + ", status=" + status + "]";
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getNotificationType() { return notificationType; }
    public void setNotificationType(String notificationType) { this.notificationType = notificationType; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public LocalDateTime getReminderDate() { return reminderDate; }
    public void setReminderDate(LocalDateTime reminderDate) { this.reminderDate = reminderDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
