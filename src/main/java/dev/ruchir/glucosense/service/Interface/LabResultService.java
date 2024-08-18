package dev.ruchir.glucosense.service.Interface;

import dev.ruchir.glucosense.dto.Support_dto.LabResultDTO;

import java.util.List;

public interface LabResultService {

    List<LabResultDTO> getAllLabResults();

    LabResultDTO getLabResultById(Long id);

    List<LabResultDTO> getLabResultsByPatientId(Long patientId);

    LabResultDTO createLabResult(LabResultDTO labResultDTO);

    void deleteLabResult(Long id);

    LabResultDTO updateLabResult(Long id, LabResultDTO labResultDTO);
}