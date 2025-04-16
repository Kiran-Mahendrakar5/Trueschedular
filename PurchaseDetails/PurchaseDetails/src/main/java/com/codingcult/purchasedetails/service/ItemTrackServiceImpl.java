package com.codingcult.purchasedetails.service;

import com.codingcult.purchasedetails.client.PurchaseServiceClient;
import com.codingcult.purchasedetails.dto.ItemTrackDto;
import com.codingcult.purchasedetails.dto.PurchaseIteamsDto;
import com.codingcult.purchasedetails.repo.ItemTrackRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemTrackServiceImpl implements ItemTrackService {

    @Autowired
    private ItemTrackRepo repo;
    
    @Autowired
    private PurchaseServiceClient purchaseClient;


    @Override
    public ItemTrackDto addTrack(ItemTrackDto dto) {
        return repo.save(dto);
    }

    @Override
    public List<ItemTrackDto> getTracksByMobile(String mobile) {
        return repo.findByUserMobile(mobile);
    }

    @Override
    public ItemTrackDto updateStatus(int id, String status) {
        Optional<ItemTrackDto> optional = repo.findById(id);
        if (optional.isPresent()) {
            ItemTrackDto dto = optional.get();
            dto.setStatus(status);
            return repo.save(dto);
        }
        return null;
    }

    @Override
    public ItemTrackDto addNoteOrReceipt(int id, String note, String receipt) {
        Optional<ItemTrackDto> optional = repo.findById(id);
        if (optional.isPresent()) {
            ItemTrackDto dto = optional.get();
            dto.setNote(note);
            dto.setReceipt(receipt);
            return repo.save(dto);
        }
        return null;
    }
    @Override
    public List<ItemTrackDto> generateTracksFromPurchases(String mobile) {
        List<PurchaseIteamsDto> purchaseItems = purchaseClient.getItemsByMobile(mobile);
        List<ItemTrackDto> tracks = new ArrayList<>();

        for (PurchaseIteamsDto item : purchaseItems) {
            ItemTrackDto track = new ItemTrackDto();
            track.setItemName(item.getItemName());
            track.setUserMobile(item.getUserMobile());
            track.setStatus("PENDING"); // default
            track.setActive(true);
            tracks.add(repo.save(track)); // Save to DB
        }

        return tracks;
    }
        public void saveItems(List<PurchaseIteamsDto> items) {
            for (PurchaseIteamsDto dto : items) {
                ItemTrackDto entity = new ItemTrackDto();
                entity.setItemName(dto.getItemName());
                entity.setNote(String.valueOf(dto.getPrice()));
                entity.setUserMobile(dto.getUserMobile());
                entity.setStatus("SAVED");
                repo.save(entity); // ✅ Fix here
            }
        }

    

}