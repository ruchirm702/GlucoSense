package dev.ruchir.glucosense.service.Interface;

import dev.ruchir.glucosense.controller_advise.Custom_Exceptions.MedicationNotFoundException;
import dev.ruchir.glucosense.controller_advise.Standard_Exceptions.BadRequestException;
import dev.ruchir.glucosense.dto.Core_Dto.MedicationDTO;

import java.util.List;

public interface MedicationService {
    MedicationDTO createMedication(MedicationDTO medicationDTO) throws BadRequestException;
    MedicationDTO updateMedication(Long id, MedicationDTO medicationDTO) throws MedicationNotFoundException, BadRequestException;
    void deleteMedication(Long id) throws MedicationNotFoundException;
    MedicationDTO getMedicationById(Long id) throws MedicationNotFoundException;
    List<MedicationDTO> getAllMedications();
    List<MedicationDTO> getMedicationsByPatientId(Long patientId);
    List<MedicationDTO> getMedicationsByName(String name);
}