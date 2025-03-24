package com.codingcult.trueschedulercontroller;

import com.codingcult.truescheduler.dto.BillDto;
import com.codingcult.truescheduler.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    @Autowired
    private BillService service;

    @PostMapping
    public BillDto addBill(@RequestBody BillDto bill) {
        return service.addBill(bill);
    }

    @GetMapping
    public List<BillDto> getAllBills() {
        return service.getAllBills();
    }

    @GetMapping("/{id}")
    public BillDto getBillById(@PathVariable Long id) {
        return service.getBillById(id);
    }

    @PutMapping("/{id}")
    public BillDto updateBill(@PathVariable Long id, @RequestBody BillDto bill) {
        return service.updateBill(id, bill);
    }

    @DeleteMapping("/{id}")
    public void deleteBill(@PathVariable Long id) {
        service.deleteBill(id);
    }

    @GetMapping("/notifications")
    public List<BillDto> getDueDateNotifications() {
        return service.getDueDateNotifications();
    }

    @GetMapping("/auto-payments")
    public List<BillDto> getAutoPaymentReminders() {
        return service.getAutoPaymentReminders();
    }
}
