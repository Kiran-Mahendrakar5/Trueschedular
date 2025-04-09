package com.codingcult.reminder.dto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "bill_reminders")
public class BillReminderDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Bill type cannot be blank")
    @Column(name = "bill_type", nullable = false)
    private String billType;

    @NotNull(message = "Amount cannot be null")
    @Column(name = "amount", nullable = false)
    private Double amount;

    @NotNull(message = "Due date cannot be null")
    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @NotBlank(message = "Payment method cannot be blank")
    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @Column(name = "auto_payment_enabled")
    private boolean autoPaymentEnabled;

    @NotBlank(message = "Phone number cannot be blank")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "is_active")
    private boolean isActive = true;

    public BillReminderDTO() {
        super();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isAutoPaymentEnabled() {
        return autoPaymentEnabled;
    }

    public void setAutoPaymentEnabled(boolean autoPaymentEnabled) {
        this.autoPaymentEnabled = autoPaymentEnabled;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}