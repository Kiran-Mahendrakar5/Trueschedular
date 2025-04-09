
package com.codingcult.settingsconfig.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codingcult.settingsconfig.dto.NotificationSettingsDTO;
import java.util.Optional;

public interface NotificationSettingsRepository extends JpaRepository<NotificationSettingsDTO, Long> {
    Optional<NotificationSettingsDTO> findByPhoneNumber(String phoneNumber);
}
