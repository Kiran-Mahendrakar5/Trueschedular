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

    @PostMapping("/{backupType}")
    public BackupDTO createBackup(@PathVariable String backupType) {
        return backupService.createBackup(backupType.toUpperCase());
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
