package dev.ruchir.glucosense.service.Implementation;

import dev.ruchir.glucosense.model.Core.Prescription;
import dev.ruchir.glucosense.model.Enum.PrescriptionStatus;
import dev.ruchir.glucosense.repository.PrescriptionRepository;
import dev.ruchir.glucosense.service.Interface.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;

    @Autowired
    public PrescriptionServiceImpl(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    @Override
    public Prescription savePrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    @Override
    public Optional<Prescription> getPrescriptionById(Long id) {
        return prescriptionRepository.findById(id);
    }

    @Override
    public List<Prescription> getPrescriptionsByPatientId(Long patientId) {
        return prescriptionRepository.findByPatientId(patientId);
    }

    @Override
    public List<Prescription> getPrescriptionsByDoctorId(Long doctorId) {
        return prescriptionRepository.findByDoctorId(doctorId);
    }

    @Override
    public List<Prescription> getPrescriptionsByMedicationId(Long medicationId) {
        return prescriptionRepository.findByMedicationId(medicationId);
    }

    @Override
    public List<Prescription> getPrescriptionsByStatus(PrescriptionStatus status) {
        return prescriptionRepository.findByStatus(status);
    }

    @Override
    public List<Prescription> getPrescriptionsBetweenDates(LocalDate startDate, LocalDate endDate) {
        return prescriptionRepository.findByPrescriptionDateBetween(startDate, endDate);
    }

    @Override
    public Optional<Prescription> getLatestPrescriptionByPatientId(Long patientId) {
        return prescriptionRepository.findTopByPatientIdOrderByPrescriptionDateDesc(patientId);
    }

    @Override
    public List<Prescription> getPrescriptionsByPatientIdAndStatus(Long patientId, PrescriptionStatus status) {
        return prescriptionRepository.findByPatientIdAndStatus(patientId, status);
    }

    @Override
    public void deletePrescription(Long id) {
        prescriptionRepository.deleteById(id);
    }
}
