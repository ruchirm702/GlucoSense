package dev.ruchir.glucosense.contoller;

import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.ConsultationNotFoundException;
import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.InvalidConsultationDataException;
import dev.ruchir.glucosense.dto.Core_Dto.ConsultationDTO;
import dev.ruchir.glucosense.dto.Core_Dto.DoctorDTO;
import dev.ruchir.glucosense.service.Interface.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultations")
@Validated
public class ConsultationController {

    private final ConsultationService consultationService;

    @Autowired
    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    // Create a new consultation
    @PostMapping
    public ResponseEntity<ConsultationDTO> createConsultation(@RequestBody @Validated ConsultationDTO consultationDTO) {
        try {
            ConsultationDTO createdConsultation = consultationService.createConsultation(consultationDTO);
            return new ResponseEntity<>(createdConsultation, HttpStatus.CREATED);
        } catch (InvalidConsultationDataException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Update an existing consultation
    @PutMapping("/{id}")
    public ResponseEntity<ConsultationDTO> updateConsultation(
            @PathVariable Long id, @RequestBody @Validated ConsultationDTO consultationDTO) {
        try {
            ConsultationDTO updatedConsultation = consultationService.updateConsultation(id, consultationDTO);
            return new ResponseEntity<>(updatedConsultation, HttpStatus.OK);
        } catch (ConsultationNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (InvalidConsultationDataException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Get consultation by ID
    @GetMapping("/{id}")
    public ResponseEntity<ConsultationDTO> getConsultationById(@PathVariable Long id) {
        try {
            ConsultationDTO consultation = consultationService.getConsultationById(id);
            return new ResponseEntity<>(consultation, HttpStatus.OK);
        } catch (ConsultationNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Get all consultations for a specific patient
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<ConsultationDTO>> getConsultationsByPatientId(@PathVariable Long patientId) {
        List<ConsultationDTO> consultations = consultationService.getConsultationsByPatientId(patientId);
        return new ResponseEntity<>(consultations, HttpStatus.OK);
    }

    // Get all consultations for a specific doctor
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<ConsultationDTO>> getConsultationsByDoctorId(@PathVariable Long doctorId) {
        List<ConsultationDTO> consultations = consultationService.getConsultationsByDoctorId(doctorId);
        return new ResponseEntity<>(consultations, HttpStatus.OK);
    }

    // Delete a consultation by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsultation(@PathVariable Long id) {
        try {
            consultationService.deleteConsultation(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ConsultationNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get all doctors associated with a specific patient
    @GetMapping("/patient/{patientId}/doctors")
    public ResponseEntity<List<DoctorDTO>> getDoctorsByPatientId(@PathVariable Long patientId) {
        List<DoctorDTO> doctors = consultationService.getDoctorsByPatientId(patientId);
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }
}
