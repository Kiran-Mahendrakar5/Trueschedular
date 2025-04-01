package com.codingcult.settingsconfig.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingcult.settingsconfig.dto.BackupDTO;

import java.util.List;

@Repository
public interface BackupRepository extends JpaRepository<BackupDTO, Long> {
    List<BackupDTO> findByBackupType(String backupType);
}
