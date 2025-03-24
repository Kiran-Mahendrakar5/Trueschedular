package com.codingcult.truescheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingcult.truescheduler.dto.LanguageDto;

import com.codingcult.truescheduler.repo.LanguageRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageRepository repository;

	@Override
	public LanguageDto createLanguage(LanguageDto dto) {
		// Map DTO to Entity
		LanguageDto language = new LanguageDto();
		language.setLanguageName(dto.getLanguageName());
		language.setCountry(dto.getCountry());
		language.setDefaultLanguage(dto.isDefaultLanguage());

		// Save and map back to DTO
		LanguageDto saved = repository.save(language);

		return new LanguageDto(saved.getId(), saved.getLanguageName(), saved.getCountry(), saved.isDefaultLanguage());
	}

	@Override
	public LanguageDto getLanguageById(Long id) {
		LanguageDto language = repository.findById(id).orElseThrow(() -> new RuntimeException("Language not found"));

		return new LanguageDto(language.getId(), language.getLanguageName(), language.getCountry(),
				language.isDefaultLanguage());
	}

	@Override
	public List<LanguageDto> getAllLanguages() {
		List<LanguageDto> languages = repository.findAll(); // Fetch entities

		// Map entities to DTOs
		return languages.stream().map(lang -> new LanguageDto(lang.getId(), lang.getLanguageName(), lang.getCountry(),
				lang.isDefaultLanguage())).collect(Collectors.toList());
	}

	@Override
	public LanguageDto updateLanguage(Long id, LanguageDto dto) {
		LanguageDto language = repository.findById(id).orElseThrow(() -> new RuntimeException("Language not found"));

		language.setLanguageName(dto.getLanguageName());
		language.setCountry(dto.getCountry());
		language.setDefaultLanguage(dto.isDefaultLanguage());

		LanguageDto updated = repository.save(language);

		return new LanguageDto(updated.getId(), updated.getLanguageName(), updated.getCountry(),
				updated.isDefaultLanguage());
	}

	@Override
	public void deleteLanguage(Long id) {
		if (!repository.existsById(id)) {
			throw new RuntimeException("Language not found");
		}
		repository.deleteById(id);
	}
}
