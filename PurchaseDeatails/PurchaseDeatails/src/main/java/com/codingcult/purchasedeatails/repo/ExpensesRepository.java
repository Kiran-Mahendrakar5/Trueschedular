package com.codingcult.purchasedeatails.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingcult.purchasedeatails.dto.ExpensesDto;

@Repository
public interface ExpensesRepository extends JpaRepository<ExpensesDto, Long> {
    // You can add custom query methods here if needed, for example:
    // List<ExpensesDto> findByUserName(String userName);
}
