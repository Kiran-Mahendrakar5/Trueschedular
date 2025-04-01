package com.codingcult.settingsconfig.service;

import com.codingcult.settingsconfig.dto.PrivacySettingsDTO;

public interface PrivacySettingsService {

    PrivacySettingsDTO savePrivacySettings(Long userId, PrivacySettingsDTO privacySettingsDTO);

    PrivacySettingsDTO getPrivacySettings(Long userId);

    PrivacySettingsDTO updatePrivacySettings(Long userId, Boolean dataEncryptionEnabled, Boolean canRead, Boolean canWrite, Boolean canDelete);

    PrivacySettingsDTO enableDataEncryption(Long userId);

    PrivacySettingsDTO disableDataEncryption(Long userId);

    PrivacySettingsDTO updatePermissions(Long userId, Boolean canRead, Boolean canWrite, Boolean canDelete);
}
