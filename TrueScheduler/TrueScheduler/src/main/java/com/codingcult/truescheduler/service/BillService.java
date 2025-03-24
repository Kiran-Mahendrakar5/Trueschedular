package com.codingcult.truescheduler.service;

import com.codingcult.truescheduler.dto.BillDto;

import java.util.List;

public interface BillService {

	public BillDto addBill(BillDto bill);

	public List<BillDto> getAllBills();

	public BillDto getBillById(Long id);

	public BillDto updateBill(Long id, BillDto bill);

	public void deleteBill(Long id);

	public List<BillDto> getDueDateNotifications();

	public List<BillDto> getAutoPaymentReminders();
}
