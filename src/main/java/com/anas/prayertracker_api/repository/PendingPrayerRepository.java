package com.anas.prayertracker_api.repository;

import com.anas.prayertracker_api.entity.PendingPrayer;
import com.anas.prayertracker_api.enums.PrayerName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PendingPrayerRepository
        extends JpaRepository<PendingPrayer, Long> {

    List<PendingPrayer> findByFirebaseUid(String firebaseUid);

    void deleteByFirebaseUidAndPrayerNameAndPrayerDate(
            String firebaseUid,
            PrayerName prayerName,
            LocalDate prayerDate
    );
}