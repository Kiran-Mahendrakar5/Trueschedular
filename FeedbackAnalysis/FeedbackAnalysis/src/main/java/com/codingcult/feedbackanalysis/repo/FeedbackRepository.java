package com.codingcult.feedbackanalysis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingcult.feedbackanalysis.dto.FeedbackDTO;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackDTO, Long> {
}
