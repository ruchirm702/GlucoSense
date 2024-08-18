package dev.ruchir.glucosense.contoller;

import dev.ruchir.glucosense.dto.Core_Dto.BloodSugarRecordDTO;
import dev.ruchir.glucosense.service.Interface.BloodSugarRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/blood-sugar-records")
public class BloodSugarRecordController {

    private final BloodSugarRecordService bloodSugarRecordService;

    @Autowired
    public BloodSugarRecordController(BloodSugarRecordService bloodSugarRecordService) {
        this.bloodSugarRecordService = bloodSugarRecordService;
    }

    @PostMapping
    public ResponseEntity<BloodSugarRecordDTO> createBloodSugarRecord(@RequestBody BloodSugarRecordDTO bloodSugarRecordDTO) {
        BloodSugarRecordDTO createdRecord = bloodSugarRecordService.createBloodSugarRecord(bloodSugarRecordDTO);
        return new ResponseEntity<>(createdRecord, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BloodSugarRecordDTO> getBloodSugarRecordById(@PathVariable Long id) {
        BloodSugarRecordDTO recordDTO = bloodSugarRecordService.getBloodSugarRecordById(id);
        return new ResponseEntity<>(recordDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BloodSugarRecordDTO>> getAllBloodSugarRecords() {
        List<BloodSugarRecordDTO> records = bloodSugarRecordService.getAllBloodSugarRecords();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<BloodSugarRecordDTO>> getBloodSugarRecordsByPatientId(@PathVariable Long patientId) {
        List<BloodSugarRecordDTO> records = bloodSugarRecordService.getBloodSugarRecordsByPatientId(patientId);
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @GetMapping("/between-dates")
    public ResponseEntity<List<BloodSugarRecordDTO>> getBloodSugarRecordsBetweenDates(
            @RequestParam("start") LocalDateTime start,
            @RequestParam("end") LocalDateTime end) {
        List<BloodSugarRecordDTO> records = bloodSugarRecordService.getBloodSugarRecordsBetweenDates(start, end);
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BloodSugarRecordDTO> updateBloodSugarRecord(
            @PathVariable Long id, @RequestBody BloodSugarRecordDTO bloodSugarRecordDTO) {
        BloodSugarRecordDTO updatedRecord = bloodSugarRecordService.updateBloodSugarRecord(id, bloodSugarRecordDTO);
        return new ResponseEntity<>(updatedRecord, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBloodSugarRecord(@PathVariable Long id) {
        bloodSugarRecordService.deleteBloodSugarRecord(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}