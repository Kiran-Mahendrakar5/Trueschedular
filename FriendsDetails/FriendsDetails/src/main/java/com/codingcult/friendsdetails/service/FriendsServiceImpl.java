package com.codingcult.friendsdetails.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingcult.friendsdetails.dto.FriendsDTO;
import com.codingcult.friendsdetails.repo.FriendsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FriendsServiceImpl implements FriendsService {

    @Autowired
    private FriendsRepository friendsRepository;

    @Override
    public FriendsDTO addFriend(FriendsDTO friendDTO) {
        Optional<FriendsDTO> existing = friendsRepository.findByPhoneNumber(friendDTO.getPhoneNumber());
        if (existing.isPresent()) {
            throw new RuntimeException("Friend with this phone number already exists!");
        }
        return friendsRepository.save(friendDTO);
    }

    @Override
    public List<FriendsDTO> getAllActiveFriends() {
        return friendsRepository.findAllByIsActiveTrue();
    }

    @Override
    public boolean enableLocationTracking(Long friendId) {
        FriendsDTO friend = friendsRepository.findById(friendId)
                .orElseThrow(() -> new RuntimeException("Friend not found!"));
        friend.setLocationTrackingEnabled(true);
        friendsRepository.save(friend);
        return true;
    }

    @Override
    public void removeFriend(Long friendId) {
        FriendsDTO friend = friendsRepository.findById(friendId)
                .orElseThrow(() -> new RuntimeException("Friend not found!"));
        friend.setActive(false);
        friendsRepository.save(friend); // Soft delete
    }
}
