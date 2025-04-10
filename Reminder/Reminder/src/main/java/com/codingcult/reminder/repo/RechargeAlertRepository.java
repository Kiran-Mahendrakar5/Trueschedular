package com.codingcult.reminder.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingcult.reminder.dto.RechargeAlertDTO;

import java.util.List;

@Repository
public interface RechargeAlertRepository extends JpaRepository<RechargeAlertDTO, Long> {

    List<RechargeAlertDTO> findByIsActiveTrue();

    List<RechargeAlertDTO> findByMobileNumberAndIsActiveTrue(String mobileNumber);

    List<RechargeAlertDTO> findByBalanceLessThanAndIsActiveTrue(Double threshold);
}
