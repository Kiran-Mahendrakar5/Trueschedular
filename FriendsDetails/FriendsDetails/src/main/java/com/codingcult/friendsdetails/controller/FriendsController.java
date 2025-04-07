package com.codingcult.friendsdetails.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcult.friendsdetails.dto.FriendsDTO;
import com.codingcult.friendsdetails.service.FriendsService;

import java.util.List;

@RestController
@RequestMapping("/api/friends")
public class FriendsController {

    @Autowired
    private FriendsService friendsService;

    @PostMapping
    public FriendsDTO addFriend(@RequestBody FriendsDTO friendDTO) {
        return friendsService.addFriend(friendDTO);
    }

    @GetMapping
    public List<FriendsDTO> getAllActiveFriends() {
        return friendsService.getAllActiveFriends();
    }

    @PutMapping("/enable-location/{friendId}")
    public String enableLocationTracking(@PathVariable Long friendId) {
        if (friendsService.enableLocationTracking(friendId)) {
            return "Location tracking enabled.";
        } else {
            return "Failed to enable tracking.";
        }
    }

    @DeleteMapping("/{id}")
    public String removeFriend(@PathVariable Long id) {
        friendsService.removeFriend(id);
        return "Friend removed successfully!";
    }
}
