package com.codingcult.settingsconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcult.settingsconfig.dto.PrivacySettingsDTO;
import com.codingcult.settingsconfig.service.PrivacySettingsService;

@RestController
@RequestMapping("/api/privacy-settings")
public class PrivacySettingsController {

    @Autowired
    private PrivacySettingsService privacySettingsService;

    @PostMapping("/{userId}")
    public PrivacySettingsDTO createPrivacySettings(@PathVariable Long userId,
                                                    @RequestBody PrivacySettingsDTO privacySettingsDTO) {
        return privacySettingsService.savePrivacySettings(userId, privacySettingsDTO);
    }

    @GetMapping("/{userId}")
    public PrivacySettingsDTO getPrivacySettings(@PathVariable Long userId) {
        return privacySettingsService.getPrivacySettings(userId);
    }

    @PutMapping("/{userId}")
    public PrivacySettingsDTO updatePrivacySettings(@PathVariable Long userId,
                                                    @RequestParam Boolean dataEncryptionEnabled,
                                                    @RequestParam Boolean canRead,
                                                    @RequestParam Boolean canWrite,
                                                    @RequestParam Boolean canDelete) {
        return privacySettingsService.updatePrivacySettings(userId, dataEncryptionEnabled, canRead, canWrite, canDelete);
    }

    @PutMapping("/{userId}/enable-encryption")
    public PrivacySettingsDTO enableDataEncryption(@PathVariable Long userId) {
        return privacySettingsService.enableDataEncryption(userId);
    }

    @PutMapping("/{userId}/disable-encryption")
    public PrivacySettingsDTO disableDataEncryption(@PathVariable Long userId) {
        return privacySettingsService.disableDataEncryption(userId);
    }

    @PutMapping("/{userId}/update-permissions")
    public PrivacySettingsDTO updatePermissions(@PathVariable Long userId,
                                                @RequestParam Boolean canRead,
                                                @RequestParam Boolean canWrite,
                                                @RequestParam Boolean canDelete) {
        return privacySettingsService.updatePermissions(userId, canRead, canWrite, canDelete);
    }
}