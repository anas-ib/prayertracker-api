package com.anas.prayertracker_api.controller;

import com.anas.prayertracker_api.dto.AddPrayerRequest;
import com.anas.prayertracker_api.dto.PrayerResponse;
import com.anas.prayertracker_api.service.PendingPrayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Add a pending prayer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prayer added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "403", description = "Authentication failed or access denied"),
            @ApiResponse(responseCode = "409", description = "Prayer already exists for this date")
    })

    @PostMapping
    public PrayerResponse addPrayer(
            Authentication authentication,
            @Valid @RequestBody AddPrayerRequest request
    ) {

        String firebaseUid = authentication.getName();

        return service.addPrayer(firebaseUid, request);
    }

    @Operation(summary = "Get all pending prayers for the authenticated user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pending prayers retrieved successfully"),
            @ApiResponse(responseCode = "403", description = "Authentication failed or access denied")
    })

    @GetMapping
    public List<PrayerResponse> getPendingPrayers(
            Authentication authentication
    ) {

        String firebaseUid = authentication.getName();

        return service.getPendingPrayers(firebaseUid);
    }

    @Operation(summary = "Delete a pending prayer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Prayer deleted successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "403", description = "Authentication failed or access denied")
    })

    @DeleteMapping
    public void deletePrayer(
            Authentication authentication,
            @Valid @RequestBody AddPrayerRequest request
    ) {

        String firebaseUid = authentication.getName();

        service.deletePrayer(firebaseUid, request);
    }
}