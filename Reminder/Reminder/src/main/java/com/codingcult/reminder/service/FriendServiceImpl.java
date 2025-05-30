package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.FriendDto;
import com.codingcult.reminder.dto.ReminderDto;
import com.codingcult.reminder.feign.ReminderServiceClient;
import com.codingcult.reminder.repo.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    private ReminderService reminderService;

    @Autowired
    private FriendRepository friendRepository; // Inject repository
    
    @Autowired
    private ReminderServiceClient reminderClient;

    public void addFriend1(FriendDto friendDto) {
        // Save friend to database (omitted for brevity)

        // Trigger birthday reminder
        ReminderDto reminder = new ReminderDto();
        reminder.setTitle("Birthday Alert: " + friendDto.getName());
        reminder.setCategory("Birthday");
        reminder.setReminderTime(friendDto.getBirthday().atTime(9, 0)); // 9 AM on birthday
        reminder.setPhoneNumber(friendDto.getPhone());
        reminder.setMessage("Wish your friend " + friendDto.getName() + " a Happy Birthday!");
        reminder.setActive(true);
        reminder.setRecurring(true);
        reminder.setRepeatCycle("YEARLY");

        reminderClient.saveReminder(reminder);
    }

    // Method to add friend
    @Override
    public String addFriend(FriendDto friend) {
        FriendDto savedFriend = friendRepository.save(friend); // Save to DB
        sendBirthdayReminder(savedFriend); // Optional birthday reminder
        return "Friend added successfully!";
    }

    // Method to send a birthday reminder via ReminderService
    @Override
    public void sendBirthdayReminder(FriendDto friend) {
        if (friend.getBirthday() != null && friend.getBirthday().isEqual(LocalDate.now())) {
            reminderService.sendReminder(friend.getPhone(), "Happy Birthday, " + friend.getName() + "!");
        }
    }

    // Method to set event visibility (private/shared)
    @Override
    public void setEventVisibility(FriendDto friend, boolean isShared) {
        friend.setEventShared(isShared);
        friendRepository.save(friend); // Update in DB
    }

    // Method to link friend to a group
    @Override
    public void linkFriendToGroup(FriendDto friend, String groupName) {
        friend.setLinkedToGroup(true);
        friendRepository.save(friend); // Update in DB
        reminderService.sendReminder(friend.getPhone(), "You have been added to group: " + groupName);
    }
}
