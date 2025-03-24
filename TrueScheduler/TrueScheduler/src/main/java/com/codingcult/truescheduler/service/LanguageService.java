package com.codingcult.truescheduler.service;

import java.util.List;

import com.codingcult.truescheduler.dto.LanguageDto;

public interface LanguageService {
	public LanguageDto createLanguage(LanguageDto languageDTO);

	public LanguageDto getLanguageById(Long id);

	public List<LanguageDto> getAllLanguages();

	public LanguageDto updateLanguage(Long id, LanguageDto languageDTO);

	public void deleteLanguage(Long id);

}
