package dev.ruchir.glucosense.repository;

import dev.ruchir.glucosense.model.support.LabResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabResultRepository extends JpaRepository<LabResult, Long> {
    List<LabResult> findByPatientId(Long patientId);
    List<LabResult> findByTestName(String testName);
}
