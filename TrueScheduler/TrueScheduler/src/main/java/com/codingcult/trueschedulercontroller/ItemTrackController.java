package com.codingcult.trueschedulercontroller;

import com.codingcult.truescheduler.dto.ItemTrackDto;
import com.codingcult.truescheduler.service.ItemTrackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/item-tracks")
public class ItemTrackController {

    @Autowired
    private ItemTrackService itemTrackService;

    @PostMapping
    public ItemTrackDto createItemTrack(@RequestBody ItemTrackDto itemTrackDto) {
        return itemTrackService.saveItemTrack(itemTrackDto);
    }

    @GetMapping
    public List<ItemTrackDto> getAllItemTracks() {
        return itemTrackService.getAllItemTracks();
    }

    @GetMapping("/{id}")
    public ItemTrackDto getItemTrackById(@PathVariable Long id) {
        Optional<ItemTrackDto> track = itemTrackService.getItemTrackById(id);
        return track.orElse(null);
    }

    @PutMapping("/{id}")
    public ItemTrackDto updateItemTrack(@PathVariable Long id, @RequestBody ItemTrackDto itemTrackDto) {
        return itemTrackService.updateItemTrack(id, itemTrackDto);
    }

    @DeleteMapping("/{id}")
    public void deleteItemTrack(@PathVariable Long id) {
        itemTrackService.deleteItemTrack(id);
    }
}
