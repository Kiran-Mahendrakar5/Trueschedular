package com.codingcult.settingsconfig.service;

import java.util.List;
import com.codingcult.settingsconfig.dto.BackupDTO;

public interface BackupService {
    BackupDTO createBackup(String backupType, String phoneNumber);
    List<BackupDTO> getBackupHistory();
    String restoreBackup(Long backupId);
}