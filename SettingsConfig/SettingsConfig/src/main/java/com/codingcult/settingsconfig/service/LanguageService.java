package com.codingcult.settingsconfig.service;

import com.codingcult.settingsconfig.dto.LanguageDTO;

import java.util.List;

public interface LanguageService {
	LanguageDTO addLanguage(LanguageDTO language);
    List<LanguageDTO> getAllLanguages();
    LanguageDTO changeDefaultLanguage(String languageCode);
    LanguageDTO getDefaultLanguage();
}
