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

    @PostMapping("/save")
    public String saveLanguageConfig(@RequestBody LanguageConfigDto configDto) {
        return languageConfigService.saveLanguageConfig(configDto);
    }

    @GetMapping("/{phoneNumber}")
    public LanguageConfigDto getLanguageConfig(@PathVariable String phoneNumber) {
        return languageConfigService.getLanguageConfigByPhone(phoneNumber);
    }
}
