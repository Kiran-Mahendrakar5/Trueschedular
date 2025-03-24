package com.codingcult.trueschedulercontroller;

import com.codingcult.truescheduler.dto.RechargeDto;
import com.codingcult.truescheduler.service.RechargeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recharge")
public class RechargeController {

    @Autowired
    private RechargeService service;

    @PostMapping
    public ResponseEntity<RechargeDto> saveRecharge(@RequestBody RechargeDto dto) {
        return ResponseEntity.ok(service.saveRecharge(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RechargeDto> getRechargeById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRechargeById(id));
    }

    @GetMapping
    public ResponseEntity<List<RechargeDto>> getAllRecharges() {
        return ResponseEntity.ok(service.getAllRecharges());
    }

    @GetMapping("/suggest/{mobileNumber}")
    public ResponseEntity<List<RechargeDto>> suggestBestPlans(@PathVariable String mobileNumber) {
        return ResponseEntity.ok(service.suggestBestPlans(mobileNumber));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecharge(@PathVariable Long id) {
        service.deleteRecharge(id);
        return ResponseEntity.ok("Recharge deleted successfully.");
    }
}
