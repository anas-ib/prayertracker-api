package com.anas.prayertracker_api.entity;

import com.anas.prayertracker_api.enums.PrayerName;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "pending_prayers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PendingPrayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firebase_uid", nullable = false)
    private String firebaseUid;

    @Column(name = "prayer_name", nullable = false)
    @Enumerated(EnumType.STRING)
    private PrayerName prayerName;

    @Column(name = "prayer_date", nullable = false)
    private LocalDate prayerDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}