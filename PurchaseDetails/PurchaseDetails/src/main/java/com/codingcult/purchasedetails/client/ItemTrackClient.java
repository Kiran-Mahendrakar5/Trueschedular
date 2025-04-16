package com.codingcult.purchasedetails.client;

import com.codingcult.purchasedetails.dto.ItemTrackDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "item-track-service", url = "${item.track.service.url}")
public interface ItemTrackClient {

    @GetMapping("/track/mobile/{mobile}")
    List<ItemTrackDto> getTracks(@PathVariable("mobile") String userMobile);

    @PutMapping("/track/status/{id}")
    ItemTrackDto updateStatus(@PathVariable("id") int id, @RequestParam("status") String status);

    @PutMapping("/track/note-receipt/{id}")
    ItemTrackDto addNoteOrReceipt(@PathVariable("id") int id,
                                   @RequestParam(required = false) String note,
                                   @RequestParam(required = false) String receipt);
}
