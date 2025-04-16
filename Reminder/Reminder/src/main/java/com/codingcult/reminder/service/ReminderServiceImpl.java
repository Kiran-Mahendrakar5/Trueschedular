package com.codingcult.reminder.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingcult.reminder.dto.BillReminderDto;
import com.codingcult.reminder.dto.PopupNotificationDto;
import com.codingcult.reminder.dto.RechargeAlertDto;
import com.codingcult.reminder.dto.ReminderDto;
import com.codingcult.reminder.enums.NotificationStatus;
import com.codingcult.reminder.feign.ExpenseTrackerServiceClient;
import com.codingcult.reminder.feign.NotificationServiceClient;
import com.codingcult.reminder.feign.ReminderServiceClient;
import com.codingcult.reminder.repo.ReminderRepository;
import com.codingcult.reminder.service.PopupNotificationService;  // Assuming this service exists

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReminderServiceImpl implements ReminderService {

    @Autowired
    private ReminderRepository repository;
    
    @Autowired
    private NotificationServiceClient notificationServiceClient;
    
    @Autowired
    private ExpenseTrackerServiceClient expenseTrackerServiceClient;
    
    @Autowired
    private ReminderServiceClient reminderClient;  // Autowired missing client

    @Autowired
    private PopupNotificationService popupNotificationService; // Added PopupNotificationService

    private List<RechargeAlertDto> rechargeAlerts = new ArrayList<>();

    public String addRechargeAlert(RechargeAlertDto dto) {
        rechargeAlerts.add(dto);
        
        // Trigger reminder if nearing expiry (sample logic)
        LocalDate expiryDate = dto.getLastRechargeDate().plusDays(dto.getValidityPeriodDays());

        if (expiryDate.minusDays(2).isEqual(LocalDate.now())) { // 2 days before expiry
            ReminderDto reminder = new ReminderDto();
            reminder.setPhoneNumber(dto.getMobileNumber());
            reminder.setTitle("Recharge Reminder");
            reminder.setDescription("Your recharge is about to expire in 2 days for operator " + dto.getOperator());
            reminder.setCategory("Recharge");

            reminderClient.triggerReminder(reminder); // Send alert to reminder service
        }

        return "Recharge alert added successfully.";
    }

    public void createBillReminder(BillReminderDto billReminderDto) {
        // Create Reminder
        ReminderDto reminder = new ReminderDto();
        reminder.setTitle("Bill Reminder: " + billReminderDto.getBillType());
        reminder.setCategory("Bill");
        reminder.setReminderTime(billReminderDto.getAlertTime());
        reminder.setRecurring(false);
        reminder.setActive(true);

        // Save Reminder to the database
        repository.save(reminder);

        // Call ExpenseTrackerService using Feign
        expenseTrackerServiceClient.trackExpense(billReminderDto.getBillType(), billReminderDto.getAmount());

        // Schedule the Notification
        notificationServiceClient.scheduleNotification(reminder, billReminderDto.getAlertTime());
    }

    @Override
    public String saveReminder(ReminderDto dto) {
        repository.save(dto);
        return "Reminder saved successfully.";
    }

    @Override
    public List<ReminderDto> getAllActiveReminders() {
        return repository.findByIsActiveTrue();
    }

    @Override
    public List<ReminderDto> getRemindersByCategory(String category) {
        return repository.findByCategory(category);
    }

    @Override
    public void sendReminder(String phoneOrEmail, String message) {
        // Implement your notification logic (SMS, Push Notification, etc.)
        System.out.println("Sending reminder to " + phoneOrEmail + ": " + message);
    }

    // Scheduled task to trigger reminders at their reminder time
    @Scheduled(cron = "0 0 * * * ?") // Every hour, you can change the cron as needed
    public void checkAndSendReminders() {
        List<ReminderDto> reminders = repository.findByIsActiveTrue();

        // Get the current time
        LocalDateTime now = LocalDateTime.now();

        for (ReminderDto reminder : reminders) {
            // If the reminder time is equal to the current time, send the reminder
            if (reminder.getReminderTime().isBefore(now) || reminder.getReminderTime().isEqual(now)) {
                // Call send reminder logic (SMS, email, etc.)
                System.out.println("🔔 Sending reminder: " + reminder.getTitle() + " at " + reminder.getReminderTime());

                // Optionally, call external services (e.g., push notifications or SMS) via Feign client
                sendReminder(reminder.getCategory(), reminder.getTitle());

                // Optionally, mark as completed or inactive after sending
                reminder.setActive(false);  // or implement your logic
                repository.save(reminder);
            }
        }
    }

    public void triggerReminderPopup(String phoneNumber, String reminderMessage) {
        PopupNotificationDto popup = new PopupNotificationDto();
        popup.setTitle("Reminder");
        popup.setMessage(reminderMessage);
        popup.setUserPhoneNumber(phoneNumber);
        popup.setTimestamp(LocalDateTime.now().toString());
        popup.setStatus(NotificationStatus.PENDING);

        // Trigger the popup notification
        popupNotificationService.triggerPopup(popup);
    }

    @Override
    public List<ReminderDto> getRemindersByPhoneNumber(String phoneNumber) {
        // Assuming your ReminderRepository has a method to find reminders by phone number
        return repository.findByPhoneNumber(phoneNumber);
    }
    


}
