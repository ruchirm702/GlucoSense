package dev.ruchir.glucosense.contoller;

import dev.ruchir.glucosense.model.Core.Prescription;
import dev.ruchir.glucosense.model.Enum.PrescriptionStatus;
import dev.ruchir.glucosense.service.Interface.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @Autowired
    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @PostMapping
    public ResponseEntity<Prescription> createPrescription(@RequestBody Prescription prescription) {
        Prescription savedPrescription = prescriptionService.savePrescription(prescription);
        return new ResponseEntity<>(savedPrescription, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable Long id) {
        Optional<Prescription> prescription = prescriptionService.getPrescriptionById(id);
        return prescription.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Prescription>> getPrescriptionsByPatientId(@PathVariable Long patientId) {
        List<Prescription> prescriptions = prescriptionService.getPrescriptionsByPatientId(patientId);
        return ResponseEntity.ok(prescriptions);
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Prescription>> getPrescriptionsByDoctorId(@PathVariable Long doctorId) {
        List<Prescription> prescriptions = prescriptionService.getPrescriptionsByDoctorId(doctorId);
        return ResponseEntity.ok(prescriptions);
    }

    @GetMapping("/medication/{medicationId}")
    public ResponseEntity<List<Prescription>> getPrescriptionsByMedicationId(@PathVariable Long medicationId) {
        List<Prescription> prescriptions = prescriptionService.getPrescriptionsByMedicationId(medicationId);
        return ResponseEntity.ok(prescriptions);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Prescription>> getPrescriptionsByStatus(@PathVariable PrescriptionStatus status) {
        List<Prescription> prescriptions = prescriptionService.getPrescriptionsByStatus(status);
        return ResponseEntity.ok(prescriptions);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<Prescription>> getPrescriptionsBetweenDates(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        List<Prescription> prescriptions = prescriptionService.getPrescriptionsBetweenDates(startDate, endDate);
        return ResponseEntity.ok(prescriptions);
    }

    @GetMapping("/latest/patient/{patientId}")
    public ResponseEntity<Prescription> getLatestPrescriptionByPatientId(@PathVariable Long patientId) {
        Optional<Prescription> prescription = prescriptionService.getLatestPrescriptionByPatientId(patientId);
        return prescription.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/patient/{patientId}/status/{status}")
    public ResponseEntity<List<Prescription>> getPrescriptionsByPatientIdAndStatus(
            @PathVariable Long patientId,
            @PathVariable PrescriptionStatus status) {
        List<Prescription> prescriptions = prescriptionService.getPrescriptionsByPatientIdAndStatus(patientId, status);
        return ResponseEntity.ok(prescriptions);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrescription(@PathVariable Long id) {
        prescriptionService.deletePrescription(id);
        return ResponseEntity.noContent().build();
    }
}
