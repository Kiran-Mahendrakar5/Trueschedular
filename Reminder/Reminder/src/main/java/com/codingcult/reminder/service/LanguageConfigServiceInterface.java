package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.LanguageConfigDto;

public interface LanguageConfigServiceInterface {
    String saveLanguageConfig(LanguageConfigDto configDto);
    LanguageConfigDto getLanguageConfigByPhone(String phoneNumber);
}
