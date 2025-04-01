package com.codingcult.settingsconfig.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingcult.settingsconfig.dto.LanguageDTO;
import com.codingcult.settingsconfig.repo.LanguageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public LanguageDTO addLanguage(LanguageDTO languageDTO) {
        return languageRepository.save(languageDTO);
    }

    @Override
    public List<LanguageDTO> getAllLanguages() {
        return languageRepository.findAll();
    }

    @Override
    public LanguageDTO changeDefaultLanguage(String languageCode) {
        Optional<LanguageDTO> currentDefault = languageRepository.findByIsDefaultTrue();
        Optional<LanguageDTO> newDefault = languageRepository.findByLanguageCode(languageCode);

        if (newDefault.isEmpty()) {
            throw new RuntimeException("Language not found!");
        }

        currentDefault.ifPresent(lang -> {
            lang.setDefault(false);
            languageRepository.save(lang);
        });

        LanguageDTO updatedLanguage = newDefault.get();
        updatedLanguage.setDefault(true);
        return languageRepository.save(updatedLanguage);
    }

    @Override
    public LanguageDTO getDefaultLanguage() {
        return languageRepository.findByIsDefaultTrue().orElseThrow(() -> new RuntimeException("No default language found!"));
    }
}
