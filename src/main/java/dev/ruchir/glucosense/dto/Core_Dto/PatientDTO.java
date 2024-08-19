package dev.ruchir.glucosense.dto.Core_Dto;

import dev.ruchir.glucosense.dto.Enum_dto.BloodTypeDTO;
import dev.ruchir.glucosense.dto.Support_dto.AllergyDTO;
import dev.ruchir.glucosense.dto.Support_dto.EmergencyContactDTO;
import dev.ruchir.glucosense.dto.Support_dto.LabResultDTO;
import dev.ruchir.glucosense.dto.Support_dto.RoleDTO;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
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
    private String userStatus;
    private String contactDetails; // Assuming this is a string for now; adapt as necessary.
}
