package com.codingcult.truescheduler.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingcult.truescheduler.dto.Scheduling_UserPurchaseDto;

@Repository
public interface SchedulingUserPurchaseRepository extends JpaRepository<Scheduling_UserPurchaseDto, Long> {
}
