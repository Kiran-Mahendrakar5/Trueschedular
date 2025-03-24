package com.codingcult.truescheduler.repo;



import com.codingcult.truescheduler.dto.RechargeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RechargeRepository extends JpaRepository<RechargeDto, Long> {
    List<RechargeDto> findByMobileNumber(String mobileNumber);
}

