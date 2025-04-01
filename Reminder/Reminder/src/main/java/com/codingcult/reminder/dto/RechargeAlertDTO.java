package com.codingcult.reminder.dto;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "recharge_alerts")
public class RechargeAlertDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Mobile number cannot be blank")
    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    @NotNull(message = "Balance cannot be null")
    @Min(value = 0, message = "Balance must be a positive value")
    @Column(name = "balance", nullable = false)
    private Double balance;

    @NotNull(message = "Threshold cannot be null")
    @Min(value = 1, message = "Threshold must be greater than 0")
    @Column(name = "threshold", nullable = false)
    private Double threshold;

    @NotBlank(message = "Plan name cannot be blank")
    @Column(name = "plan_name", nullable = false)
    private String planName;

    @NotNull(message = "Price cannot be null")
    @Min(value = 1, message = "Price must be greater than 0")
    @Column(name = "price", nullable = false)
    private Double price;

    @NotBlank(message = "Validity cannot be blank")
    @Column(name = "validity", nullable = false)
    private String validity;

    @NotBlank(message = "Data limit cannot be blank")
    @Column(name = "data_limit", nullable = false)
    private String dataLimit;

    @NotBlank(message = "User email cannot be blank")
    @Column(name = "user_email", nullable = false)
    private String userEmail;

    public RechargeAlertDTO() {
    }

    public RechargeAlertDTO(Long id, String mobileNumber, Double balance, Double threshold, String planName, Double price, String validity, String dataLimit, String userEmail) {
        this.id = id;
        this.mobileNumber = mobileNumber;
        this.balance = balance;
        this.threshold = threshold;
        this.planName = planName;
        this.price = price;
        this.validity = validity;
        this.dataLimit = dataLimit;
        this.userEmail = userEmail;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getThreshold() {
		return threshold;
	}

	public void setThreshold(Double threshold) {
		this.threshold = threshold;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public String getDataLimit() {
		return dataLimit;
	}

	public void setDataLimit(String dataLimit) {
		this.dataLimit = dataLimit;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
    
    

    // Getters and Setters
}
