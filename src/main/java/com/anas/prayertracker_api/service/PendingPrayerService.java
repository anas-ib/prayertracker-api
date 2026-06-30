package com.anas.prayertracker_api.service;

import com.anas.prayertracker_api.dto.AddPrayerRequest;
import com.anas.prayertracker_api.dto.PrayerResponse;
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

    public PrayerResponse addPrayer(String firebaseUid, AddPrayerRequest request) {

        PendingPrayer prayer = PendingPrayer.builder()
                .firebaseUid(firebaseUid)
                .prayerName(request.getPrayerName())
                .prayerDate(request.getPrayerDate())
                .createdAt(LocalDateTime.now())
                .build();

        PendingPrayer savedPrayer = repository.save(prayer);

        return mapToResponse(savedPrayer);
    }

    public List<PrayerResponse> getPendingPrayers(String firebaseUid) {

        return repository.findByFirebaseUid(firebaseUid)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public void deletePrayer(String firebaseUid, AddPrayerRequest request) {

        repository.deleteByFirebaseUidAndPrayerNameAndPrayerDate(
                firebaseUid,
                request.getPrayerName(),
                request.getPrayerDate()
        );
    }

    private PrayerResponse mapToResponse(PendingPrayer prayer) {

        return PrayerResponse.builder()
                .id(prayer.getId())
                .prayerName(prayer.getPrayerName())
                .prayerDate(prayer.getPrayerDate())
                .createdAt(prayer.getCreatedAt())
                .build();
    }
}