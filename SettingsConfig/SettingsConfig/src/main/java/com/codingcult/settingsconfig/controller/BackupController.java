package com.codingcult.settingsconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.codingcult.settingsconfig.dto.BackupDTO;
import com.codingcult.settingsconfig.service.BackupService;
import java.util.List;

@RestController
@RequestMapping("/api/backups")
public class BackupController {

    @Autowired
    private BackupService backupService;

    @PostMapping("/{backupType}/{phoneNumber}")
    public BackupDTO createBackup(@PathVariable String backupType, @PathVariable String phoneNumber) {
        return backupService.createBackup(backupType.toUpperCase(), phoneNumber);
    }

    @GetMapping
    public List<BackupDTO> getBackupHistory() {
        return backupService.getBackupHistory();
    }

    @PostMapping("/restore/{backupId}")
    public String restoreBackup(@PathVariable Long backupId) {
        return backupService.restoreBackup(backupId);
    }
}