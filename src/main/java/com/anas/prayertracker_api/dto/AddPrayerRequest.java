package com.anas.prayertracker_api.dto;

import com.anas.prayertracker_api.enums.PrayerName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddPrayerRequest {

    @NotNull(message = "Prayer name is required")
    private PrayerName prayerName;

    @NotNull(message = "Prayer date is required")
    private LocalDate prayerDate;
}