package dev.ruchir.glucosense.service.Interface;

import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.MeasurementNotFoundException;
import dev.ruchir.glucosense.dto.Core_Dto.MeasurementDTO;

import java.util.List;

public interface MeasurementService {
    MeasurementDTO createMeasurement(MeasurementDTO measurementDTO);
    MeasurementDTO getMeasurementById(Long id) throws MeasurementNotFoundException;
    List<MeasurementDTO> getAllMeasurements();

    MeasurementDTO saveMeasurement(MeasurementDTO measurementDTO);

    MeasurementDTO updateMeasurement(Long id, MeasurementDTO measurementDTO) throws MeasurementNotFoundException;

    List<MeasurementDTO> getMeasurementsByPatientId(Long patientId);

    void deleteMeasurement(Long id) throws MeasurementNotFoundException;
}