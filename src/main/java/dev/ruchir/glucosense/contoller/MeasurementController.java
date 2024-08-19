package dev.ruchir.glucosense.contoller;

import dev.ruchir.glucosense.dto.Core_Dto.MeasurementDTO;
import dev.ruchir.glucosense.service.Interface.MeasurementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {

    private final MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @PostMapping
    public ResponseEntity<MeasurementDTO> createMeasurement(@RequestBody MeasurementDTO measurementDTO) {
        MeasurementDTO createdMeasurement = measurementService.createMeasurement(measurementDTO);
        return new ResponseEntity<>(createdMeasurement, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MeasurementDTO> updateMeasurement(
            @PathVariable Long id, @RequestBody MeasurementDTO measurementDTO) {
        MeasurementDTO updatedMeasurement = measurementService.updateMeasurement(id, measurementDTO);
        return new ResponseEntity<>(updatedMeasurement, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeasurementDTO> getMeasurementById(@PathVariable Long id) {
        MeasurementDTO measurementDTO = measurementService.getMeasurementById(id);
        return new ResponseEntity<>(measurementDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MeasurementDTO>> getAllMeasurements() {
        List<MeasurementDTO> measurements = measurementService.getAllMeasurements();
        return new ResponseEntity<>(measurements, HttpStatus.OK);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<MeasurementDTO>> getMeasurementsByPatientId(@PathVariable Long patientId) {
        List<MeasurementDTO> measurements = measurementService.getMeasurementsByPatientId(patientId);
        return new ResponseEntity<>(measurements, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeasurement(@PathVariable Long id) {
        measurementService.deleteMeasurement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
