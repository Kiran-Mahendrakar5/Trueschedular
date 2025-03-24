package com.codingcult.truescheduler.service;

import com.codingcult.truescheduler.dto.RechargeDto;

import java.util.List;

public interface RechargeService {

	public  RechargeDto saveRecharge(RechargeDto dto);

	public  RechargeDto getRechargeById(Long id);

	public  List<RechargeDto> getAllRecharges();

	public  List<RechargeDto> getRechargesByMobile(String mobileNumber);

	public  void deleteRecharge(Long id);

	public  List<RechargeDto> suggestBestPlans(String mobileNumber);

	public  boolean isLowBalance(String mobileNumber, double threshold);
}

