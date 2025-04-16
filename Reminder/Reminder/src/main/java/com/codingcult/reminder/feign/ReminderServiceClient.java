package com.codingcult.reminder.feign;

import com.codingcult.reminder.dto.CalendarEventDto;
import com.codingcult.reminder.dto.DailyScheduleAlarmDto;
import com.codingcult.reminder.dto.EventDto;
import com.codingcult.reminder.dto.LocationAlertDto;
import com.codingcult.reminder.dto.ReminderDto;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "reminder-service", url = "http://localhost:9002")
public interface ReminderServiceClient {
    @PostMapping("/api/reminders/from-calendar")
    void sendReminderFromCalendar(@RequestBody CalendarEventDto event);
    
    @PostMapping("/api/reminders")
    String triggerReminder(@RequestBody ReminderDto reminder);
    
    @GetMapping("/api/reminders/active")
    List<ReminderDto> getAllActiveReminders();

    @GetMapping("/api/reminders/category/{category}")
    List<ReminderDto> getByCategory(@PathVariable("category") String category);
    
    @PostMapping("/api/reminders/set")
    String setReminder(@RequestBody ReminderDto dto);
    
    @PostMapping("/location-alerts/trigger-and-remind")
    String triggerLocationAlertAndRemind(@RequestBody LocationAlertDto locationAlertDto);
    
    @PostMapping("/dailySchedule/add") // Matches DailyScheduleAlarmController
    String addDailySchedule(@RequestBody DailyScheduleAlarmDto dto);
    
    @PostMapping("/friendsave")
    String saveReminder(@RequestBody ReminderDto dto);


    @GetMapping("/api/reminders/reminders/user/{phoneNumber}") // Fix the endpoint to match exactly.
    List<ReminderDto> getUserReminders(@PathVariable("phoneNumber") String phoneNumber);

    @GetMapping("/location-alerts/user/{phoneNumber}")
    List<LocationAlertDto> getUserLocationAlerts(@PathVariable("phoneNumber") String phoneNumber);
    
    @PostMapping("/api/reminders")
    String createReminder(@RequestBody ReminderDto reminderDTO);
    
    @PostMapping("/createReminder")
    String createReminder(@RequestBody EventDto eventDto);
    
    

}

    
    




