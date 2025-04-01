package com.codingcult.settingsconfig.service;

import java.util.List;

import com.codingcult.settingsconfig.dto.LanguageDTO;

public interface LanguageService {
    LanguageDTO addLanguage(LanguageDTO languageDTO);
    List<LanguageDTO> getAllLanguages();
    LanguageDTO changeDefaultLanguage(String languageCode);
    LanguageDTO getDefaultLanguage();
}
