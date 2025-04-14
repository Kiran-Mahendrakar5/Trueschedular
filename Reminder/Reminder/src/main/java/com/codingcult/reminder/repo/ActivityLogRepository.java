package com.codingcult.reminder.repo;

import com.codingcult.reminder.dto.ActivityLogDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityLogRepository extends JpaRepository<ActivityLogDto, Integer> {

    List<ActivityLogDto> findByUserPhoneNumber(String phoneNumber);

    List<ActivityLogDto> findByUserPhoneNumberAndActionType(String phoneNumber, String actionType);
}
