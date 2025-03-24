package com.codingcult.truescheduler.repo;



import com.codingcult.truescheduler.dto.DailyEventDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyEventRepository extends JpaRepository<DailyEventDto, Long> {
}

