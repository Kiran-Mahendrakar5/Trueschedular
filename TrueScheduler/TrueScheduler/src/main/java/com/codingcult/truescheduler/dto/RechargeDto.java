package com.codingcult.truescheduler.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "recharge_plans")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RechargeDto implements Serializable {

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

    @NotBlank(message = "Plan name cannot be blank")
    @Column(name = "plan_name", nullable = false)
    private String planName;

    @NotNull(message = "Price cannot be null")
    @Min(value = 1, message = "Price must be greater than 0")
    @Column(name = "price", nullable = false)
    private Double price;

    @NotBlank(message = "Validity cannot be blank")
    @Column(name = "validity", nullable = false)
    private String validity;  // Example: "28 days"

    @NotBlank(message = "Data limit cannot be blank")
    @Column(name = "data_limit", nullable = false)
    private String dataLimit;  // Example: "1.5GB/day"

	public RechargeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RechargeDto(Long id, @NotBlank(message = "Mobile number cannot be blank") String mobileNumber,
			@NotNull(message = "Balance cannot be null") @Min(value = 0, message = "Balance must be a positive value") Double balance,
			@NotBlank(message = "Plan name cannot be blank") String planName,
			@NotNull(message = "Price cannot be null") @Min(value = 1, message = "Price must be greater than 0") Double price,
			@NotBlank(message = "Validity cannot be blank") String validity,
			@NotBlank(message = "Data limit cannot be blank") String dataLimit) {
		super();
		this.id = id;
		this.mobileNumber = mobileNumber;
		this.balance = balance;
		this.planName = planName;
		this.price = price;
		this.validity = validity;
		this.dataLimit = dataLimit;
	}

	@Override
	public String toString() {
		return "RechargeDto [id=" + id + ", mobileNumber=" + mobileNumber + ", balance=" + balance + ", planName="
				+ planName + ", price=" + price + ", validity=" + validity + ", dataLimit=" + dataLimit + "]";
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
    
    
    
    
    
    
}
