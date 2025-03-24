package com.codingcult.truescheduler.repo;

import com.codingcult.truescheduler.dto.NotificationDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationDTO, Long> {

	// Find all notifications by status
	public List<NotificationDTO> findByStatus(String status);

	// Find notifications by userId
	public List<NotificationDTO> findByUserId(Long userId);
}
