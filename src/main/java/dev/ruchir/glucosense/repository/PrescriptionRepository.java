package dev.ruchir.glucosense.repository;

import dev.ruchir.glucosense.model.Core.Prescription;
import dev.ruchir.glucosense.model.Enum.PrescriptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    List<Prescription> findByPatientId(Long patientId);

    List<Prescription> findByDoctorId(Long doctorId);

    List<Prescription> findByMedicationId(Long medicationId);

    List<Prescription> findByStatus(PrescriptionStatus status);

    List<Prescription> findByPrescriptionDateBetween(LocalDate startDate, LocalDate endDate);

    Optional<Prescription> findTopByPatientIdOrderByPrescriptionDateDesc(Long patientId);

    List<Prescription> findByPatientIdAndStatus(Long patientId, PrescriptionStatus status);
}
