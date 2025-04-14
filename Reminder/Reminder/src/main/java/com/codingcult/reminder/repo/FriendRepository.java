package com.codingcult.reminder.repo;

import com.codingcult.reminder.dto.FriendDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<FriendDto, Integer> {
    // You can add custom finder methods here if needed
}
