package dev.ruchir.glucosense.contoller;

import dev.ruchir.glucosense.dto.Core_Dto.*;
import dev.ruchir.glucosense.dto.Support_dto.*;
import dev.ruchir.glucosense.model.Enum.*;
import dev.ruchir.glucosense.service.Interface.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        List<PatientDTO> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<PatientDTO>> getPatientsByName(@PathVariable String name) {
        List<PatientDTO> patients = patientService.getPatientsByName(name);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable Long id) {
        PatientDTO patient = patientService.getPatientById(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientDTO patientDTO) {
        PatientDTO createdPatient = patientService.createPatient(patientDTO);
        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/count/blood-type/{bloodType}")
    public ResponseEntity<Long> countPatientsByBloodType(@PathVariable BloodType bloodType) {
        Long count = patientService.countPatientsByBloodType(bloodType);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable Long id, @RequestBody PatientDTO patientDTO) {
        PatientDTO updatedPatient = patientService.updatePatient(id, patientDTO);
        return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
    }

    // New endpoints utilizing additional methods

    @GetMapping("/{patientId}/activity-records")
    public ResponseEntity<List<ActivityRecordDTO>> getActivityRecordsByPatientId(@PathVariable Long patientId) {
        List<ActivityRecordDTO> records = patientService.getActivityRecordsByPatientId(patientId);
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @GetMapping("/{patientId}/blood-sugar-records")
    public ResponseEntity<List<BloodSugarRecordDTO>> getBloodSugarRecordsByPatientId(@PathVariable Long patientId) {
        List<BloodSugarRecordDTO> records = patientService.getBloodSugarRecordsByPatientId(patientId);
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @GetMapping("/{patientId}/diet-entries")
    public ResponseEntity<List<DietEntryDTO>> getDietEntriesByPatientId(@PathVariable Long patientId) {
        List<DietEntryDTO> entries = patientService.getDietEntriesByPatientId(patientId);
        return new ResponseEntity<>(entries, HttpStatus.OK);
    }

    @GetMapping("/{patientId}/consultations")
    public ResponseEntity<List<ConsultationDTO>> getConsultationsByPatientId(@PathVariable Long patientId) {
        List<ConsultationDTO> consultations = patientService.getConsultationsByPatientId(patientId);
        return new ResponseEntity<>(consultations, HttpStatus.OK);
    }

    @GetMapping("/{patientId}/devices")
    public ResponseEntity<List<DeviceDTO>> getDevicesByPatientId(@PathVariable Long patientId) {
        List<DeviceDTO> devices = patientService.getDevicesByPatientId(patientId);
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    @GetMapping("/{patientId}/emergency-contacts")
    public ResponseEntity<List<EmergencyContactDTO>> getEmergencyContactsByPatientId(@PathVariable Long patientId) {
        List<EmergencyContactDTO> contacts = patientService.getEmergencyContactsByPatientId(patientId);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @GetMapping("/{patientId}/lab-results")
    public ResponseEntity<List<LabResultDTO>> getLabResultsByPatientId(@PathVariable Long patientId) {
        List<LabResultDTO> labResults = patientService.getLabResultsByPatientId(patientId);
        return new ResponseEntity<>(labResults, HttpStatus.OK);
    }

    @GetMapping("/{patientId}/measurements")
    public ResponseEntity<List<MeasurementDTO>> getMeasurementsByPatientId(@PathVariable Long patientId) {
        List<MeasurementDTO> measurements = patientService.getMeasurementsByPatientId(patientId);
        return new ResponseEntity<>(measurements, HttpStatus.OK);
    }

    @GetMapping("/{patientId}/medications")
    public ResponseEntity<List<MedicationDTO>> getMedicationsByPatientId(@PathVariable Long patientId) {
        List<MedicationDTO> medications = patientService.getMedicationsByPatientId(patientId);
        return new ResponseEntity<>(medications, HttpStatus.OK);
    }

    @GetMapping("/{patientId}/doctors")
    public ResponseEntity<List<DoctorDTO>> getDoctorsByPatientId(@PathVariable Long patientId) {
        List<DoctorDTO> doctors = patientService.getDoctorsByPatientId(patientId);
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @GetMapping("/{patientId}/roles")
    public ResponseEntity<List<RoleDTO>> getRolesByPatientId(@PathVariable Long patientId) {
        List<RoleDTO> roles = patientService.getRolesByPatientId(patientId);
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}
