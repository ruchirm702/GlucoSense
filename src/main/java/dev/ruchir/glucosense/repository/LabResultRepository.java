package dev.ruchir.glucosense.repository;

import dev.ruchir.glucosense.model.Core.Patient;
import dev.ruchir.glucosense.model.support.LabResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabResultRepository extends JpaRepository<LabResult, Long> {
    List<LabResult> findByPatient(Patient patient);
    List<LabResult> findByPatientId(Long patientId);
}
