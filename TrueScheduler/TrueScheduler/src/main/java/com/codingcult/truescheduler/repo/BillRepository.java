package com.codingcult.truescheduler.repo;

import com.codingcult.truescheduler.dto.BillDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<BillDto, Long> {

    List<BillDto> findByDueDate(LocalDate dueDate);

    List<BillDto> findByAutoPaymentTrue();

    List<BillDto> findByDueDateBetween(LocalDate start, LocalDate end);

}

