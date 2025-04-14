package com.codingcult.purchasedetails.controller;

import com.codingcult.purchasedetails.dto.ItemTrackDto;
import com.codingcult.purchasedetails.service.ItemTrackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/track")
public class ItemTrackController {

    @Autowired
    private ItemTrackService service;

    @PostMapping("/add")
    public ItemTrackDto addTrack(@RequestBody ItemTrackDto dto) {
        return service.addTrack(dto);
    }

    @GetMapping("/mobile/{mobile}")
    public List<ItemTrackDto> getTracks(@PathVariable String mobile) {
        return service.getTracksByMobile(mobile);
    }

    @PutMapping("/status/{id}")
    public ItemTrackDto updateStatus(@PathVariable int id, @RequestParam String status) {
        return service.updateStatus(id, status);
    }

    @PutMapping("/note-receipt/{id}")
    public ItemTrackDto addNoteReceipt(@PathVariable int id,
                                       @RequestParam(required = false) String note,
                                       @RequestParam(required = false) String receipt) {
        return service.addNoteOrReceipt(id, note, receipt);
    }
}