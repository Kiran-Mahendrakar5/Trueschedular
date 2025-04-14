package com.codingcult.feedback.repo;

import com.codingcult.feedback.dto.FeedBackDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBackRepo extends JpaRepository<FeedBackDto, Integer> {
    // Optional: custom query methods
}
