package dev.ruchir.glucosense.repository;

import dev.ruchir.glucosense.model.Core.BloodSugarRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BloodSugarRecordRepository extends JpaRepository<BloodSugarRecord, Long> {
    List<BloodSugarRecord> findByPatientId(Long patientId);
    List<BloodSugarRecord> findByRecordDateBetween(LocalDateTime start, LocalDateTime end);
}
