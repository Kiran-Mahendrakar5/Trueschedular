package com.codingcult.friendsdetails.service;

import java.util.List;

import com.codingcult.friendsdetails.dto.FriendsDTO;

public interface FriendsService {

    FriendsDTO addFriend(FriendsDTO friendDTO);

    List<FriendsDTO> getFriendsByUser(String userEmail);

    boolean enableLocationTracking(Long friendId);

    void removeFriend(Long friendId);
}
