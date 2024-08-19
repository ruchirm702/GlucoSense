package dev.ruchir.glucosense.service.Interface;

import dev.ruchir.glucosense.dto.Support_dto.EmergencyContactDTO;

import java.util.List;

public interface EmergencyContactService {
    List<EmergencyContactDTO> getEmergencyContactsByPatientId(Long patientId);
    EmergencyContactDTO getEmergencyContactById(Long id);
    EmergencyContactDTO createEmergencyContact(EmergencyContactDTO emergencyContactDTO);
    EmergencyContactDTO updateEmergencyContact(Long id, EmergencyContactDTO emergencyContactDTO);
    void deleteEmergencyContact(Long id);
}
