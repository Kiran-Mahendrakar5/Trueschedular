package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.RechargeAlertDto;
import com.codingcult.reminder.repo.RechargeAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RechargeAlertServiceImpl implements RechargeAlertService {

    @Autowired
    private RechargeAlertRepository repository;

    @Override
    public String addRechargeAlert(RechargeAlertDto dto) {
        repository.save(dto);
        return "Recharge alert added successfully!";
    }

    @Override
    public List<RechargeAlertDto> getAll() {
        return repository.findAll();
    }

    @Override
    public RechargeAlertDto getById(int id) {
        Optional<RechargeAlertDto> alert = repository.findById(id);
        return alert.orElse(null); // Return null if not found, or you can throw an exception
    }

    // Scheduled job to run every day at 9 AM
    @Scheduled(cron = "0 0 9 * * ?")
    @Override
    public void checkAndSendRechargeAlerts() {
        List<RechargeAlertDto> alerts = repository.findByIsActiveTrueAndAlertSentFalse();
        LocalDate today = LocalDate.now();

        for (RechargeAlertDto alert : alerts) {
            // Calculate the expiry date based on last recharge date and validity period
            LocalDate expiryDate = alert.getLastRechargeDate().plusDays(alert.getValidityPeriodDays());
            LocalDate notifyBefore = expiryDate.minusDays(2); // Alert 2 days before expiry

            if (!alert.isAlertSent() && (today.isEqual(notifyBefore) || today.isAfter(notifyBefore))) {
                // Send simulated reminder
                System.out.println("🔔 Sending recharge alert to: " + alert.getMobileNumber() +
                        " for operator " + alert.getOperator() + ". Expiry: " + expiryDate);

                // Optionally, send notification via external ReminderService using RestTemplate
                // ReminderRequest reminder = new ReminderRequest(alert.getMobileNumber(), "Recharge reminder: " + alert.getOperator(), expiryDate);
                // restTemplate.postForObject("http://REMINDER-SERVICE/reminder/send", reminder, String.class);

                // Mark as alert sent
                alert.setAlertSent(true);
                repository.save(alert);
            }
        }
    }
}
