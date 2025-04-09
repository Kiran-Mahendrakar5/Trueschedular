package com.codingcult.settingsconfig.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingcult.settingsconfig.dto.PrivacySettingsDTO;
import com.codingcult.settingsconfig.repo.PrivacySettingsRepository;

@Service
public class PrivacySettingsServiceImpl implements PrivacySettingsService {

    @Autowired
    private PrivacySettingsRepository privacySettingsRepository;

    @Override
    public PrivacySettingsDTO savePrivacySettings(Long userId, PrivacySettingsDTO privacySettingsDTO) {
        privacySettingsDTO.setUserId(userId);
        privacySettingsDTO.setIsActive(true);
        return privacySettingsRepository.save(privacySettingsDTO);
    }

    @Override
    public PrivacySettingsDTO getPrivacySettings(Long userId) {
        return privacySettingsRepository.findByUserId(userId);
    }

    @Override
    public PrivacySettingsDTO updatePrivacySettings(Long userId, Boolean dataEncryptionEnabled, Boolean canRead, Boolean canWrite, Boolean canDelete) {
        PrivacySettingsDTO settings = privacySettingsRepository.findByUserId(userId);
        if (settings == null) {
            throw new RuntimeException("Privacy settings not found for user ID: " + userId);
        }
        settings.setDataEncryptionEnabled(dataEncryptionEnabled);
        settings.setCanRead(canRead);
        settings.setCanWrite(canWrite);
        settings.setCanDelete(canDelete);
        return privacySettingsRepository.save(settings);
    }

    @Override
    public PrivacySettingsDTO enableDataEncryption(Long userId) {
        PrivacySettingsDTO settings = privacySettingsRepository.findByUserId(userId);
        if (settings == null) {
            throw new RuntimeException("Privacy settings not found for user ID: " + userId);
        }
        settings.setDataEncryptionEnabled(true);
        return privacySettingsRepository.save(settings);
    }

    @Override
    public PrivacySettingsDTO disableDataEncryption(Long userId) {
        PrivacySettingsDTO settings = privacySettingsRepository.findByUserId(userId);
        if (settings == null) {
            throw new RuntimeException("Privacy settings not found for user ID: " + userId);
        }
        settings.setDataEncryptionEnabled(false);
        return privacySettingsRepository.save(settings);
    }

    @Override
    public PrivacySettingsDTO updatePermissions(Long userId, Boolean canRead, Boolean canWrite, Boolean canDelete) {
        PrivacySettingsDTO settings = privacySettingsRepository.findByUserId(userId);
        if (settings == null) {
            throw new RuntimeException("Privacy settings not found for user ID: " + userId);
        }
        settings.setCanRead(canRead);
        settings.setCanWrite(canWrite);
        settings.setCanDelete(canDelete);
        return privacySettingsRepository.save(settings);
    }
}
