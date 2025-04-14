package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.FriendDto;
import com.codingcult.reminder.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friends")
public class FriendController  {

    @Autowired
    private FriendService friendService;

    // Endpoint to add a new friend
    @PostMapping("/add")
    public String addFriend(@RequestBody FriendDto friend) {
        return friendService.addFriend(friend);
    }

    // Endpoint to set event visibility (private/shared)
    @PostMapping("/setVisibility")
    public void setEventVisibility(@RequestBody FriendDto friend, @RequestParam boolean isShared) {
        friendService.setEventVisibility(friend, isShared);
    }

    // Endpoint to link friend to a group
    @PostMapping("/linkToGroup")
    public void linkFriendToGroup(@RequestBody FriendDto friend, @RequestParam String groupName) {
        friendService.linkFriendToGroup(friend, groupName);
    }
}
