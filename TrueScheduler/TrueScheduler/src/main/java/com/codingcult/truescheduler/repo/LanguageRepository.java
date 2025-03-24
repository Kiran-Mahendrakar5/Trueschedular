package com.codingcult.truescheduler.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingcult.truescheduler.dto.LanguageDto;

@Repository
public interface LanguageRepository extends JpaRepository<LanguageDto, Long> {
}
