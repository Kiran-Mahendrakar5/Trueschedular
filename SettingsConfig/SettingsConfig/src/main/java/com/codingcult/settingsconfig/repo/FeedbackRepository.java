package com.codingcult.settingsconfig.repo;

import com.codingcult.settingsconfig.dto.FeedbackDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackDTO, Long> {
    // You can add custom query methods here if needed
}
