	package com.codingcult.activitylog.service;
	
	import com.codingcult.activitylog.dto.Scheduling_UserPurchaseDto;
	import com.codingcult.activitylog.repo.SchedulingUserPurchaseRepository;
	import com.codingcult.eventdetails.dto.EventDetailsDTO;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.stereotype.Service;
	import org.springframework.web.client.RestTemplate;
	
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.List;
	import java.util.Optional;
	
	@Service
	public class SchedulingUserPurchaseService implements SchedulingUserPurchaseServiceInterface {
	
	    @Autowired
	    private SchedulingUserPurchaseRepository repository;
	    
	    @Autowired
	    private RestTemplate restTemplate;
	
	    @Override
	    public Scheduling_UserPurchaseDto savePurchase(Scheduling_UserPurchaseDto dto) {
	        return repository.save(dto);
	    }
	
	    @Override
	    public List<Scheduling_UserPurchaseDto> getAllPurchases() {
	        return repository.findByIsActiveTrue();
	    }
	
	    @Override
	    public Optional<Scheduling_UserPurchaseDto> getPurchaseById(Long id) {
	        return repository.findById(id).filter(Scheduling_UserPurchaseDto::isActive);
	    }
	
	    @Override
	    public Scheduling_UserPurchaseDto updatePurchase(Long id, Scheduling_UserPurchaseDto newDto) {
	        return repository.findById(id).map(existing -> {
	            existing.setUserName(newDto.getUserName());
	            existing.setItem(newDto.getItem());
	            existing.setAmount(newDto.getAmount());
	            existing.setLocation(newDto.getLocation());
	            existing.setPurchaseTime(newDto.getPurchaseTime());
	            return repository.save(existing);
	        }).orElseThrow(() -> new RuntimeException("Purchase not found"));
	    }
	
	    @Override
	    public int deletePurchase(Long id) {
	        return repository.findById(id).map(p -> {
	            p.setActive(false);
	            repository.save(p);
	            return 1;
	        }).orElse(0);
	    }
//	    @Override
//	    public List<EventDetailsDTO> getEventsByPhoneNumber(String phoneNumber) {
//	        String url = "http://localhost:9501/api/event-details/phone/" + phoneNumber;
//	
//	        System.out.println("Calling event-details for phone: " + phoneNumber);
//	        ResponseEntity<EventDetailsDTO[]> response = restTemplate.getForEntity(url, EventDetailsDTO[].class);
//	        EventDetailsDTO[] eventsArray = response.getBody();
//	
//	        System.out.println("Fetched Events: " + Arrays.toString(eventsArray));
//	
//	        return eventsArray != null ? Arrays.asList(eventsArray) : new ArrayList<>();
//	    }
	    
	    @Override
	    public List<EventDetailsDTO> getEventsByPhoneNumber(String phoneNumber) {
	        String url = "http://localhost:9501/api/event-details/phone/" + phoneNumber;

	        System.out.println("📞 Calling event-details service for phone: " + phoneNumber);
	        ResponseEntity<EventDetailsDTO[]> response = restTemplate.getForEntity(url, EventDetailsDTO[].class);

	        EventDetailsDTO[] eventsArray = response.getBody();

	        if (eventsArray == null || eventsArray.length == 0) {
	            System.out.println("⚠️ No events found for phone number: " + phoneNumber);
	        } else {
	            System.out.println("✅ Events received: " + Arrays.toString(eventsArray));
	        }

	        return eventsArray != null ? Arrays.asList(eventsArray) : new ArrayList<>();
	    }


	    
	
	
	
	}
