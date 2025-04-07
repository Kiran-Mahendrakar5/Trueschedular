package com.codingcult.settingsconfig.repo;

import com.codingcult.settingsconfig.dto.LanguageDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<LanguageDTO, Long> {
    Optional<LanguageDTO> findByLanguageCode(String languageCode);
    Optional<LanguageDTO> findByIsDefaultTrue();
    boolean existsByLanguageName(String languageName);  // Updated this method
}
