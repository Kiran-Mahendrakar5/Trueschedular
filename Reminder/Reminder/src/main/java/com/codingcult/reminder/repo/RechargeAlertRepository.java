package com.codingcult.reminder.repo;

import com.codingcult.reminder.dto.RechargeAlertDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RechargeAlertRepository extends JpaRepository<RechargeAlertDto, Integer> {
    List<RechargeAlertDto> findByIsActiveTrueAndAlertSentFalse();
}
