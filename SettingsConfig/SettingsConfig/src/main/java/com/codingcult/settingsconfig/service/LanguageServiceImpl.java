package com.codingcult.settingsconfig.service;

import com.codingcult.settingsconfig.dto.LanguageDTO;
import com.codingcult.settingsconfig.repo.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    private final List<String> allowedLanguages = Arrays.asList("Kannada", "English", "Hindi", "Telugu", "Tamil");

    // Initialize default languages if not already present
    @PostConstruct
    public void initLanguages() {
        for (String lang : allowedLanguages) {
            if (languageRepository.findByLanguageCode(lang.toLowerCase()).isEmpty()) {
                LanguageDTO language = new LanguageDTO(lang, lang.toLowerCase(), false, null);
                languageRepository.save(language);
            }
        }
    }

    // Add a new language after checking for duplicates
    @Override
    public LanguageDTO addLanguage(LanguageDTO language) {
        if (language == null || language.getLanguageName() == null) {
            throw new IllegalArgumentException("Language name must not be null");
        }

        String languageName = language.getLanguageName().trim();

        if (languageRepository.existsByLanguageName(languageName)) {
            throw new IllegalArgumentException("Language already exists: " + languageName);
        }

        return languageRepository.save(language);
    }

    // Retrieve all languages
    @Override
    public List<LanguageDTO> getAllLanguages() {
        return languageRepository.findAll();
    }

    // Change default language
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

    // Get the currently set default language
    @Override
    public LanguageDTO getDefaultLanguage() {
        return languageRepository.findByIsDefaultTrue()
                .orElseThrow(() -> new RuntimeException("No default language found!"));
    }
}
