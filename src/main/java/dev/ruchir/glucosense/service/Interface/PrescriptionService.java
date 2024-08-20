package dev.ruchir.glucosense.service.Interface;

import dev.ruchir.glucosense.model.Core.Prescription;
import dev.ruchir.glucosense.model.Enum.PrescriptionStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PrescriptionService {

    Prescription savePrescription(Prescription prescription);

    Optional<Prescription> getPrescriptionById(Long id);

    List<Prescription> getPrescriptionsByPatientId(Long patientId);

    List<Prescription> getPrescriptionsByDoctorId(Long doctorId);

    List<Prescription> getPrescriptionsByMedicationId(Long medicationId);

    List<Prescription> getPrescriptionsByStatus(PrescriptionStatus status);

    List<Prescription> getPrescriptionsBetweenDates(LocalDate startDate, LocalDate endDate);

    Optional<Prescription> getLatestPrescriptionByPatientId(Long patientId);

    List<Prescription> getPrescriptionsByPatientIdAndStatus(Long patientId, PrescriptionStatus status);

    void deletePrescription(Long id);
}
