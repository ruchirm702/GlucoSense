package dev.ruchir.glucosense.repository;

import dev.ruchir.glucosense.model.Core.ActivityRecord;
import dev.ruchir.glucosense.model.Enum.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRecordRepository extends JpaRepository<ActivityRecord, Long> {
    List<ActivityRecord> findByPatientId(Long patientId);
    List<ActivityRecord> findByActivityType(ActivityType activityType); // Updated to use ActivityType enum
}
