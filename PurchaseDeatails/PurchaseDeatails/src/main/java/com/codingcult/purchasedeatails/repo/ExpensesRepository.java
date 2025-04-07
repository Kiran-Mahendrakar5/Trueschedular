package com.codingcult.purchasedeatails.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.codingcult.purchasedeatails.dto.ExpensesDto;

import java.util.List;

@Repository
public interface ExpensesRepository extends JpaRepository<ExpensesDto, Long> {
    List<ExpensesDto> findByIsActiveTrue(); // Fetch only active expenses
}
