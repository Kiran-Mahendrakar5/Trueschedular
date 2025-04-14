package com.codingcult.reminder.repo;

import com.codingcult.reminder.dto.WearableSyncDto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WearableSyncRepository extends JpaRepository<WearableSyncDto, String> {
    
    // Fetch wearable sync data by user phone number
    List<WearableSyncDto> findByUserPhoneNumber(String userPhoneNumber);
}
