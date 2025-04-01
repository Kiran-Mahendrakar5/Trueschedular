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
    public BackupDTO createBackup(String backupType) {
        double size = new Random().nextDouble() * 100; // Simulating backup size

        BackupDTO backup = new BackupDTO(backupType, LocalDateTime.now(), size, "COMPLETED");
        return backupRepository.save(backup);
    }

    @Override
    public List<BackupDTO> getBackupHistory() {
        return backupRepository.findAll();
    }

    @Override
    public String restoreBackup(Long backupId) {
        BackupDTO backup = backupRepository.findById(backupId).orElseThrow(() -> new RuntimeException("Backup not found"));
        return "Backup from " + backup.getBackupDate() + " restored successfully!";
    }

    // Schedule backup every day at 2 AM
    @Scheduled(cron = "0 0 2 * * *")
    public void scheduledBackup() {
        createBackup("CLOUD");
        System.out.println("Scheduled backup completed at " + LocalDateTime.now());
    }
}
