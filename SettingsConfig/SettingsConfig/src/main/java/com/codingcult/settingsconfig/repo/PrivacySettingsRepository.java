package com.codingcult.settingsconfig.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingcult.settingsconfig.dto.PrivacySettingsDTO;

@Repository
public interface PrivacySettingsRepository extends JpaRepository<PrivacySettingsDTO, Long> {
    PrivacySettingsDTO findByUserId(Long userId);
}
