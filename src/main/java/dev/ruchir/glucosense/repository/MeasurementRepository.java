package dev.ruchir.glucosense.repository;

import dev.ruchir.glucosense.model.Core.Measurement;
import dev.ruchir.glucosense.model.Enum.MeasurementType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    List<Measurement> findByPatientId(Long patientId);
    List<Measurement> findByMeasurementType(MeasurementType measurementType);  // Use enum type
}
