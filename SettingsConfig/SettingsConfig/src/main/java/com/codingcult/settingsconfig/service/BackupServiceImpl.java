package com.codingcult.settingsconfig.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.codingcult.settingsconfig.dto.BackupDTO;
import com.codingcult.settingsconfig.repo.BackupRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class BackupServiceImpl implements BackupService {

    @Autowired
    private BackupRepository backupRepository;

    @Override
    public BackupDTO createBackup(String backupType, String phoneNumber) {
        double size = new Random().nextDouble() * 100;
        BackupDTO backup = new BackupDTO(backupType, LocalDateTime.now(), size, "COMPLETED", phoneNumber, true);
        return backupRepository.save(backup);
    }

    @Override
    public List<BackupDTO> getBackupHistory() {
        return backupRepository.findAll();
    }

    @Override
    public String restoreBackup(Long backupId) {
        BackupDTO backup = backupRepository.findById(backupId)
                .orElseThrow(() -> new RuntimeException("Backup not found"));
        return "Backup from " + backup.getBackupDate() + " restored successfully!";
    }

    @Scheduled(cron = "0 0 2 * * *")
    public void scheduledBackup() {
        createBackup("CLOUD", "9876543210");
        System.out.println("Scheduled backup completed at " + LocalDateTime.now());
    }
}