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
    public String saveLanguageConfig(LanguageConfigDto configDto) {
        LanguageConfigDto existing = languageConfigRepository.findByUserPhoneNumber(configDto.getUserPhoneNumber());
        if (existing != null) {
            configDto.setId(existing.getId());
        }
        languageConfigRepository.save(configDto);
        return "Language configuration saved successfully!";
    }

    @Override
    public LanguageConfigDto getLanguageConfigByPhone(String phoneNumber) {
        return languageConfigRepository.findByUserPhoneNumber(phoneNumber);
    }
}
