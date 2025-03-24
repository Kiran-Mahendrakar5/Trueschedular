package com.codingcult.trueschedulercontroller;

import com.codingcult.truescheduler.dto.NotificationDTO;
import com.codingcult.truescheduler.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // Create notification
    @PostMapping
    public NotificationDTO createNotification(@RequestBody NotificationDTO notificationDTO) {
        return notificationService.saveNotification(notificationDTO);
    }

    // Get notification by ID
    @GetMapping("/{id}")
    public NotificationDTO getNotificationById(@PathVariable Long id) {
        return notificationService.getNotificationById(id);
    }

    // Get all notifications
    @GetMapping
    public List<NotificationDTO> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    // Get notifications by user ID
    @GetMapping("/user/{userId}")
    public List<NotificationDTO> getNotificationsByUserId(@PathVariable Long userId) {
        return notificationService.getNotificationsByUserId(userId);
    }

    // Update notification
    @PutMapping("/{id}")
    public NotificationDTO updateNotification(
            @PathVariable Long id,
            @RequestBody NotificationDTO notificationDTO) {
        return notificationService.updateNotification(id, notificationDTO);
    }

    // Delete notification
    @DeleteMapping("/{id}")
    public String deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return "Notification deleted successfully.";
    }
}
