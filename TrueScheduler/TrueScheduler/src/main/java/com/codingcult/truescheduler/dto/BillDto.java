package com.codingcult.truescheduler.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "bills")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Bill type is required")
    private String billType;    // Recharge, Electricity, DTH, Fastag, Broadband, Cylinder, Credit Card

    @NotNull(message = "Amount is required")
    private Double amount;

    @NotNull(message = "Due date is required")
    private LocalDate dueDate;

    @NotBlank(message = "Payment method is required")
    private String paymentMethod;   // UPI, Card, Net Banking

    private boolean autoPayment;    // Auto-payment enabled or not

    private boolean notified;       // Notification status

	public BillDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillDto(Long id, @NotBlank(message = "Bill type is required") String billType,
			@NotNull(message = "Amount is required") Double amount,
			@NotNull(message = "Due date is required") LocalDate dueDate,
			@NotBlank(message = "Payment method is required") String paymentMethod, boolean autoPayment,
			boolean notified) {
		super();
		this.id = id;
		this.billType = billType;
		this.amount = amount;
		this.dueDate = dueDate;
		this.paymentMethod = paymentMethod;
		this.autoPayment = autoPayment;
		this.notified = notified;
	}

	@Override
	public String toString() {
		return "BillDto [id=" + id + ", billType=" + billType + ", amount=" + amount + ", dueDate=" + dueDate
				+ ", paymentMethod=" + paymentMethod + ", autoPayment=" + autoPayment + ", notified=" + notified + "]";
	}

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

	public boolean isAutoPayment() {
		return autoPayment;
	}

	public void setAutoPayment(boolean autoPayment) {
		this.autoPayment = autoPayment;
	}

	public boolean isNotified() {
		return notified;
	}

	public void setNotified(boolean notified) {
		this.notified = notified;
	}
    
    
    
}
