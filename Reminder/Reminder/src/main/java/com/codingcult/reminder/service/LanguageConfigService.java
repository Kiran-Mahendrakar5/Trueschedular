package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.LanguageConfigDto;
import com.codingcult.reminder.repo.LanguageConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageConfigService implements LanguageConfigServiceInterface {

    @Autowired
    private LanguageConfigRepository languageConfigRepository;

    @Override
    public String saveLanguageConfig(LanguageConfigDto languageConfigDto) {
        languageConfigRepository.save(languageConfigDto);
        return "Language and tone preferences saved successfully!";
    }

    @Override
    public LanguageConfigDto getLanguageConfigByPhone(String phoneNumber) {
        return languageConfigRepository.findByUserPhoneNumber(phoneNumber);
    }

    public String updateLanguageConfig(LanguageConfigDto languageConfigDto) {
        LanguageConfigDto existingConfig = languageConfigRepository.findByUserPhoneNumber(languageConfigDto.getUserPhoneNumber());
        if (existingConfig != null) {
            existingConfig.setPreferredLanguage(languageConfigDto.getPreferredLanguage());
            existingConfig.setPopupTone(languageConfigDto.getPopupTone());
            languageConfigRepository.save(existingConfig);
            return "Language and tone preferences updated successfully!";
        }
        return "Language configuration not found for this user!";
    }

    public void showPopupNotification(String phoneNumber, String message) {
        LanguageConfigDto userConfig = getLanguageConfigByPhone(phoneNumber);
        if (userConfig != null) {
            String language = userConfig.getPreferredLanguage();
            String tone = userConfig.getPopupTone();
            // Logic to display the popup based on the language and tone
            displayPopup(message, language, tone);
        } else {
            // Default settings if no user preferences are found
            displayPopup(message, "en", "default");
        }
    }

    // Logic for displaying the popup
    private void displayPopup(String message, String language, String tone) {
        // Here you can implement the actual logic to display the popup
        // based on language (translation) and tone (sound for alert)
        System.out.println("Displaying popup in " + language + " with " + tone + " tone: " + message);
    }
}
