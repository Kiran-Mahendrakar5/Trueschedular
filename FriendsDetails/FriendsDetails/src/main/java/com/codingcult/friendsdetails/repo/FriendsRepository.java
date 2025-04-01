package com.codingcult.friendsdetails.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingcult.friendsdetails.dto.FriendsDTO;

import java.util.List;
import java.util.Optional;

@Repository
public interface FriendsRepository extends JpaRepository<FriendsDTO, Long> {

    List<FriendsDTO> findByUserEmail(String userEmail);

    Optional<FriendsDTO> findByUserEmailAndFriendEmail(String userEmail, String friendEmail);

}
