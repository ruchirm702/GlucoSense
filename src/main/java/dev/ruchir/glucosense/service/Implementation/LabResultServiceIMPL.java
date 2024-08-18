package dev.ruchir.glucosense.service.Implementation;

import dev.ruchir.glucosense.controller_advise.Standard_Exceptions.ResourceNotFoundException;
import dev.ruchir.glucosense.dto.Core_Dto.PatientDTO;
import dev.ruchir.glucosense.dto.Support_dto.LabResultDTO;
import dev.ruchir.glucosense.model.Core.Patient;
import dev.ruchir.glucosense.model.support.LabResult;
import dev.ruchir.glucosense.repository.LabResultRepository;
import dev.ruchir.glucosense.repository.PatientRepository;
import dev.ruchir.glucosense.service.Interface.LabResultService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabResultServiceIMPL implements LabResultService {

    private final LabResultRepository labResultRepository;
    private final PatientRepository patientRepository;

    public LabResultServiceIMPL(LabResultRepository labResultRepository, PatientRepository patientRepository) {
        this.labResultRepository = labResultRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public List<LabResultDTO> getAllLabResults() {
        return labResultRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LabResultDTO getLabResultById(Long id) {
        LabResult labResult = labResultRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lab result not found"));
        return convertToDTO(labResult);
    }

    @Override
    public List<LabResultDTO> getLabResultsByPatientId(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));
        return labResultRepository.findByPatient(patient)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LabResultDTO createLabResult(LabResultDTO labResultDTO) {
        Patient patient = patientRepository.findById(labResultDTO.getPatient().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));

        LabResult labResult = new LabResult();
        labResult.setTestName(labResultDTO.getTestName());
        labResult.setResult(labResultDTO.getResult());
        labResult.setTestDate(labResultDTO.getDate().toLocalDate());
        labResult.setPatient(patient);

        labResult = labResultRepository.save(labResult);
        return convertToDTO(labResult);
    }

    @Override
    public void deleteLabResult(Long id) {
        LabResult labResult = labResultRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lab result not found"));
        labResultRepository.delete(labResult);
    }

    @Override
    public LabResultDTO updateLabResult(Long id, LabResultDTO labResultDTO) {
        LabResult existingLabResult = labResultRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lab result not found"));

        existingLabResult.setTestName(labResultDTO.getTestName());
        existingLabResult.setResult(labResultDTO.getResult());
        existingLabResult.setTestDate(labResultDTO.getDate().toLocalDate());

        LabResult updatedLabResult = labResultRepository.save(existingLabResult);
        return convertToDTO(updatedLabResult);
    }

    private LabResultDTO convertToDTO(LabResult labResult) {
        LabResultDTO dto = new LabResultDTO();
        dto.setId(labResult.getId());
        dto.setTestName(labResult.getTestName());
        dto.setResult(labResult.getResult());
        dto.setDate(labResult.getTestDate().atStartOfDay());

        // Assuming PatientDTO contains only ID for simplicity
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(labResult.getPatient().getId());
        dto.setPatient(patientDTO);

        return dto;
    }
}