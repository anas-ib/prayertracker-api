package com.anas.prayertracker_api.controller;

import com.anas.prayertracker_api.dto.AddPrayerRequest;
import com.anas.prayertracker_api.entity.PendingPrayer;
import com.anas.prayertracker_api.service.PendingPrayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prayers")
@RequiredArgsConstructor
public class PendingPrayerController {

    private final PendingPrayerService service;

    @PostMapping
    public PendingPrayer addPrayer(
            Authentication authentication,
            @Valid @RequestBody AddPrayerRequest request
    ) {

        String firebaseUid = authentication.getName();

        return service.addPrayer(firebaseUid, request);
    }

    @GetMapping
    public List<PendingPrayer> getPendingPrayers(
            Authentication authentication
    ) {

        String firebaseUid = authentication.getName();

        return service.getPendingPrayers(firebaseUid);
    }

    @DeleteMapping
    public void deletePrayer(
            Authentication authentication,
            @Valid @RequestBody AddPrayerRequest request
    ) {

        String firebaseUid = authentication.getName();

        service.deletePrayer(firebaseUid, request);
    }
}