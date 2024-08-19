package dev.ruchir.glucosense.service.Interface;

import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.MeasurementNotFoundException;
import dev.ruchir.glucosense.dto.Core_Dto.MeasurementDTO;

import java.util.List;

public interface MeasurementService {
    MeasurementDTO createMeasurement(MeasurementDTO measurementDTO);
    MeasurementDTO updateMeasurement(Long id, MeasurementDTO measurementDTO);
    MeasurementDTO getMeasurementById(Long id);
    List<MeasurementDTO> getAllMeasurements();
    List<MeasurementDTO> getMeasurementsByPatientId(Long patientId);
    void deleteMeasurement(Long id);
}