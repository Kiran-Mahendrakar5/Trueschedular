package com.codingcult.trueschedulercontroller;

import com.codingcult.truescheduler.dto.DailyEventDto;
import com.codingcult.truescheduler.service.DailyEventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dailyevent")
public class DailyEventController {

    @Autowired
    private DailyEventService eventService;

    @PostMapping
    public DailyEventDto createEvent(@RequestBody DailyEventDto eventDto) {
        return eventService.createEvent(eventDto);
    }

    @GetMapping
    public List<DailyEventDto> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public DailyEventDto getEventById(@PathVariable Long id) {
        return eventService.getEventById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public DailyEventDto updateEvent(@PathVariable Long id, @RequestBody DailyEventDto eventDto) {
        return eventService.updateEvent(id, eventDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }

    @PutMapping("/{id}/stop")
    public void stopAlarm(@PathVariable Long id) {
        eventService.stopAlarm(id);
    }

    @PutMapping("/{id}/pause")
    public void pauseAlarm(@PathVariable Long id) {
        eventService.pauseAlarm(id);
    }

    @PutMapping("/{id}/remind-later")
    public void remindLater(@PathVariable Long id, @RequestParam int minutes) {
        eventService.remindLater(id, minutes);
    }
}
