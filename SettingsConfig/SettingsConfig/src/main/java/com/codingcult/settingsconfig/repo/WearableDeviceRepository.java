package com.codingcult.settingsconfig.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingcult.settingsconfig.dto.WearableDeviceDTO;

import java.util.Optional;

@Repository
public interface WearableDeviceRepository extends JpaRepository<WearableDeviceDTO, Long> {
    Optional<WearableDeviceDTO> findByDeviceId(String deviceId);
}
