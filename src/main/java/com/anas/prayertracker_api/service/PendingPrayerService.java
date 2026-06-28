package com.anas.prayertracker_api.service;

import com.anas.prayertracker_api.dto.AddPrayerRequest;
import com.anas.prayertracker_api.entity.PendingPrayer;
import com.anas.prayertracker_api.repository.PendingPrayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PendingPrayerService {

    private final PendingPrayerRepository repository;

    public PendingPrayer addPrayer(String firebaseUid, AddPrayerRequest request) {

        PendingPrayer prayer = PendingPrayer.builder()
                .firebaseUid(firebaseUid)
                .prayerName(request.getPrayerName())
                .prayerDate(request.getPrayerDate())
                .createdAt(LocalDateTime.now())
                .build();

        return repository.save(prayer);
    }

    public List<PendingPrayer> getPendingPrayers(String firebaseUid) {
        return repository.findByFirebaseUid(firebaseUid);
    }

    public void deletePrayer(String firebaseUid, AddPrayerRequest request) {

        repository.deleteByFirebaseUidAndPrayerNameAndPrayerDate(
                firebaseUid,
                request.getPrayerName(),
                request.getPrayerDate()
        );
    }
}