package dev.ruchir.glucosense.service.Interface;

import dev.ruchir.glucosense.dto.Core_Dto.*;
import dev.ruchir.glucosense.dto.Support_dto.DeviceDTO;
import dev.ruchir.glucosense.dto.Support_dto.EmergencyContactDTO;
import dev.ruchir.glucosense.dto.Support_dto.LabResultDTO;
import dev.ruchir.glucosense.dto.Support_dto.RoleDTO;
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

    List<ActivityRecordDTO> getActivityRecordsByPatientId(Long patientId);

    List<BloodSugarRecordDTO> getBloodSugarRecordsByPatientId(Long patientId);

    List<DietEntryDTO> getDietEntriesByPatientId(Long patientId);

    List<ConsultationDTO> getConsultationsByPatientId(Long patientId);

    List<DeviceDTO> getDevicesByPatientId(Long patientId);

    List<EmergencyContactDTO> getEmergencyContactsByPatientId(Long patientId);

    List<LabResultDTO> getLabResultsByPatientId(Long patientId);

    List<MeasurementDTO> getMeasurementsByPatientId(Long patientId);

    List<MedicationDTO> getMedicationsByPatientId(Long patientId);

    List<DoctorDTO> getDoctorsByPatientId(Long patientId);

    List<RoleDTO> getRolesByPatientId(Long patientId);
}
