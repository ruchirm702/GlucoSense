package dev.ruchir.glucosense.dto.Core_Dto;

import dev.ruchir.glucosense.dto.Enum_dto.BloodTypeDTO;
import dev.ruchir.glucosense.dto.Support_dto.AllergyDTO;
import dev.ruchir.glucosense.dto.Support_dto.EmergencyContactDTO;
import dev.ruchir.glucosense.dto.Support_dto.LabResultDTO;
import dev.ruchir.glucosense.dto.Support_dto.RoleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email; // Add this line
    private LocalDate dateOfBirth;
    private BloodTypeDTO bloodType;
    private RoleDTO role;
    private List<ConsultationDTO> consultations;
    private List<BloodSugarRecordDTO> bloodSugarRecords;
    private List<DietEntryDTO> dietEntries;
    private List<ActivityRecordDTO> activityRecords;
    private List<MeasurementDTO> measurements;
    private List<AllergyDTO> allergies;
    private EmergencyContactDTO emergencyContact;
    private List<LabResultDTO> labResults;
    private List<MedicationDTO> medications;
}
