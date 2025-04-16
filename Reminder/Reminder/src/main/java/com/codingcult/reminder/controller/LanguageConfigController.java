package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.LanguageConfigDto;
import com.codingcult.reminder.service.LanguageConfigServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/language-config")
public class LanguageConfigController {

    @Autowired
    private LanguageConfigServiceInterface languageConfigService;

    @GetMapping("/{phoneNumber}")
    public LanguageConfigDto getUserLanguageConfig(@PathVariable String phoneNumber) {
        return languageConfigService.getLanguageConfigByPhone(phoneNumber);
    }

    @PostMapping("/save")
    public String saveLanguageConfig(@RequestBody LanguageConfigDto languageConfigDto) {
        return languageConfigService.saveLanguageConfig(languageConfigDto);
    }

    @PutMapping("/update")
    public String updateLanguageConfig(@RequestBody LanguageConfigDto languageConfigDto) {
        return languageConfigService.saveLanguageConfig(languageConfigDto);
    }
}
