package com.codingcult.reminder.repo;

import com.codingcult.reminder.dto.LanguageConfigDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageConfigRepository extends JpaRepository<LanguageConfigDto, Integer> {
    LanguageConfigDto findByUserPhoneNumber(String userPhoneNumber);
}
