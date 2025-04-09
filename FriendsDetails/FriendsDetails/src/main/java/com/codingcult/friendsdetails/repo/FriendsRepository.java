package com.codingcult.friendsdetails.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.codingcult.friendsdetails.dto.FriendsDTO;

import java.util.Optional;
import java.util.List;

@Repository
public interface FriendsRepository extends JpaRepository<FriendsDTO, Long> {

    Optional<FriendsDTO> findByPhoneNumber(String phoneNumber);

    List<FriendsDTO> findAllByIsActiveTrue();
}
