package com.codingcult.activitylog.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingcult.activitylog.dto.Scheduling_UserPurchaseDto;

@Repository
public interface SchedulingUserPurchaseRepository extends JpaRepository<Scheduling_UserPurchaseDto, Long> {
    List<Scheduling_UserPurchaseDto> findByIsActiveTrue(); // 🔥 Only fetch active ones
}
