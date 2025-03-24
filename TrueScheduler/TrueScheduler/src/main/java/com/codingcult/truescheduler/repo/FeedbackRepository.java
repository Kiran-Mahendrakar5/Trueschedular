package com.codingcult.truescheduler.repo;

import com.codingcult.truescheduler.dto.FeedbackDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackDto, Long> {
}
