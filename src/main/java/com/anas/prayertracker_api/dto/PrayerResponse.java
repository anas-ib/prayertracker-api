package com.anas.prayertracker_api.dto;

import com.anas.prayertracker_api.enums.PrayerName;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrayerResponse {

    private Long id;

    private PrayerName prayerName;

    private LocalDate prayerDate;

    private LocalDateTime createdAt;
}