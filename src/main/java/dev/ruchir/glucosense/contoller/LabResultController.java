package dev.ruchir.glucosense.contoller;

import dev.ruchir.glucosense.dto.Support_dto.LabResultDTO;
import dev.ruchir.glucosense.service.Interface.LabResultService;
import dev.ruchir.glucosense.controller_advise.ErrorResponse;
import dev.ruchir.glucosense.controller_advise.Standard_Exceptions.ResourceNotFoundException;
import dev.ruchir.glucosense.controller_advise.Standard_Exceptions.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/lab-results")
public class LabResultController {

    private final LabResultService labResultService;

    public LabResultController(LabResultService labResultService) {
        this.labResultService = labResultService;
    }

    @GetMapping
    public ResponseEntity<List<LabResultDTO>> getAllLabResults() {
        List<LabResultDTO> labResults = labResultService.getAllLabResults();
        return ResponseEntity.ok(labResults);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLabResultById(@PathVariable("id") Long id) {
        try {
            LabResultDTO labResultDTO = labResultService.getLabResultById(id);
            return ResponseEntity.ok(labResultDTO);
        } catch (ResourceNotFoundException ex) {
            ErrorResponse errorResponse = new ErrorResponse(
                    "Lab result not found",
                    "RESOURCE_NOT_FOUND",
                    LocalDateTime.now(),
                    HttpStatus.NOT_FOUND,
                    UUID.randomUUID().toString() // Generating a unique error ID
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<?> getLabResultsByPatientId(@PathVariable("patientId") Long patientId) {
        try {
            List<LabResultDTO> labResults = labResultService.getLabResultsByPatientId(patientId);
            return ResponseEntity.ok(labResults);
        } catch (ResourceNotFoundException ex) {
            ErrorResponse errorResponse = new ErrorResponse(
                    "Patient not found",
                    "RESOURCE_NOT_FOUND",
                    LocalDateTime.now(),
                    HttpStatus.NOT_FOUND,
                    UUID.randomUUID().toString() // Generating a unique error ID
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @PostMapping
    public ResponseEntity<?> createLabResult(@RequestBody LabResultDTO labResultDTO) {
        try {
            LabResultDTO createdLabResult = labResultService.createLabResult(labResultDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdLabResult);
        } catch (BadRequestException ex) {
            ErrorResponse errorResponse = new ErrorResponse(
                    "Invalid input data",
                    "BAD_REQUEST",
                    LocalDateTime.now(),
                    HttpStatus.BAD_REQUEST,
                    UUID.randomUUID().toString() // Generating a unique error ID
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLabResult(@PathVariable("id") Long id,
                                             @RequestBody LabResultDTO labResultDTO) {
        try {
            LabResultDTO updatedLabResult = labResultService.updateLabResult(id, labResultDTO);
            return ResponseEntity.ok(updatedLabResult);
        } catch (ResourceNotFoundException ex) {
            ErrorResponse errorResponse = new ErrorResponse(
                    "Lab result not found",
                    "RESOURCE_NOT_FOUND",
                    LocalDateTime.now(),
                    HttpStatus.NOT_FOUND,
                    UUID.randomUUID().toString() // Generating a unique error ID
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        } catch (BadRequestException ex) {
            ErrorResponse errorResponse = new ErrorResponse(
                    "Invalid input data",
                    "BAD_REQUEST",
                    LocalDateTime.now(),
                    HttpStatus.BAD_REQUEST,
                    UUID.randomUUID().toString() // Generating a unique error ID
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLabResult(@PathVariable("id") Long id) {
        try {
            labResultService.deleteLabResult(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException ex) {
            ErrorResponse errorResponse = new ErrorResponse(
                    "Lab result not found",
                    "RESOURCE_NOT_FOUND",
                    LocalDateTime.now(),
                    HttpStatus.NOT_FOUND,
                    UUID.randomUUID().toString() // Generating a unique error ID
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
}
