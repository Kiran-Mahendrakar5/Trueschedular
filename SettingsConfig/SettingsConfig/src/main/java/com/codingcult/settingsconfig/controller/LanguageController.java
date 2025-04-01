package com.codingcult.settingsconfig.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcult.settingsconfig.dto.LanguageDTO;
import com.codingcult.settingsconfig.service.LanguageService;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @PostMapping
    public LanguageDTO addLanguage(@RequestBody LanguageDTO languageDTO) {
        return languageService.addLanguage(languageDTO);
    }

    @GetMapping
    public List<LanguageDTO> getAllLanguages() {
        return languageService.getAllLanguages();
    }

    @PutMapping("/default/{languageCode}")
    public LanguageDTO changeDefaultLanguage(@PathVariable String languageCode) {
        return languageService.changeDefaultLanguage(languageCode);
    }

    @GetMapping("/default")
    public LanguageDTO getDefaultLanguage() {
        return languageService.getDefaultLanguage();
    }
}
