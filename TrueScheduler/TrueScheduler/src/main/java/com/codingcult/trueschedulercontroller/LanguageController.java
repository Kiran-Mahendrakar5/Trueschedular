package com.codingcult.trueschedulercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcult.truescheduler.dto.LanguageDto;
import com.codingcult.truescheduler.service.LanguageService;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {

	@Autowired
	private LanguageService service;

	@PostMapping
	public LanguageDto addLanguage(@RequestBody LanguageDto dto) {
		return service.createLanguage(dto);
	}

	@GetMapping("/{id}")
	public LanguageDto getLanguageById(@PathVariable Long id) {
		return service.getLanguageById(id);
	}

	@GetMapping
	public List<LanguageDto> getAllLanguages() {
		return service.getAllLanguages();
	}

	@PutMapping("/{id}")
	public LanguageDto updateLanguage(@PathVariable Long id, @RequestBody LanguageDto dto) {
		return service.updateLanguage(id, dto);
	}

	@DeleteMapping("/{id}")
	public String deleteLanguage(@PathVariable Long id) {
		service.deleteLanguage(id);
		return "Language deleted successfully.";
	}
}
