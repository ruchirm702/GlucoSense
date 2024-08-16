package dev.ruchir.glucosense.service.Interface;

import dev.ruchir.glucosense.dto.Core_Dto.PatientDTO;
import dev.ruchir.glucosense.model.Enum.BloodType;

import java.util.List;

public interface PatientService {
    List<PatientDTO> getAllPatients();
    List<PatientDTO> getPatientsByName(String name);
    PatientDTO getPatientById(Long id);
    PatientDTO createPatient(PatientDTO patientDTO);
    void deletePatient(Long id);
    Long countPatientsByBloodType(BloodType bloodType);
    PatientDTO updatePatient(Long id, PatientDTO patientDTO); // Updated signature
}
