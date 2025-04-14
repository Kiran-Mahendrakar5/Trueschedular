package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.FriendDto;

public interface FriendService {

    // Method to add a new friend
    String addFriend(FriendDto friend);

    // Method to send birthday reminder
    void sendBirthdayReminder(FriendDto friend);

    // Method to set event visibility for a friend (private/shared)
    void setEventVisibility(FriendDto friend, boolean isShared);

    // Method to link a friend to a group
    void linkFriendToGroup(FriendDto friend, String groupName);
}
