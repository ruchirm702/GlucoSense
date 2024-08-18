package dev.ruchir.glucosense.contoller;

import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.MedicationNotFoundException;
import dev.ruchir.glucosense.controller_advise.Standard_Exceptions.BadRequestException;
import dev.ruchir.glucosense.dto.Core_Dto.MedicationDTO;
import dev.ruchir.glucosense.service.Interface.MedicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medications")
public class MedicationController {

    private final MedicationService medicationService;

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @PostMapping
    public ResponseEntity<MedicationDTO> createMedication(@RequestBody MedicationDTO medicationDTO) {
        try {
            MedicationDTO createdMedication = medicationService.createMedication(medicationDTO);
            return new ResponseEntity<>(createdMedication, HttpStatus.CREATED);
        } catch (BadRequestException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicationDTO> updateMedication(
            @PathVariable("id") Long id,
            @RequestBody MedicationDTO medicationDTO) {
        try {
            MedicationDTO updatedMedication = medicationService.updateMedication(id, medicationDTO);
            return new ResponseEntity<>(updatedMedication, HttpStatus.OK);
        } catch (MedicationNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (BadRequestException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedication(@PathVariable("id") Long id) {
        try {
            medicationService.deleteMedication(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (MedicationNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicationDTO> getMedicationById(@PathVariable("id") Long id) {
        try {
            MedicationDTO medicationDTO = medicationService.getMedicationById(id);
            return new ResponseEntity<>(medicationDTO, HttpStatus.OK);
        } catch (MedicationNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<MedicationDTO>> getAllMedications() {
        List<MedicationDTO> medications = medicationService.getAllMedications();
        return new ResponseEntity<>(medications, HttpStatus.OK);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<MedicationDTO>> getMedicationsByPatientId(@PathVariable("patientId") Long patientId) {
        List<MedicationDTO> medications = medicationService.getMedicationsByPatientId(patientId);
        return new ResponseEntity<>(medications, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<MedicationDTO>> getMedicationsByName(@PathVariable("name") String name) {
        List<MedicationDTO> medications = medicationService.getMedicationsByName(name);
        return new ResponseEntity<>(medications, HttpStatus.OK);
    }
//    private void validateMedicationDTO(MedicationDTO medicationDTO) throws BadRequestException {
//        if (medicationDTO.getName() == null || medicationDTO.getName().isEmpty()) {
//            throw new BadRequestException("Medication name must not be empty");
//        }
//        if (medicationDTO.getDosage() == null || medicationDTO.getDosage().isEmpty()) {
//            throw new BadRequestException("Medication dosage must not be empty");
//        }
//        if (medicationDTO.getType() == null || medicationDTO.getType().getTypeName() == null || medicationDTO.getType().getTypeName().isEmpty()) {
//            throw new BadRequestException("Medication type must not be empty");
//        }
//    }

}
