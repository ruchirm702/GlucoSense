package dev.ruchir.glucosense.dto.Core_Dto;



import java.time.LocalDateTime;

import dev.ruchir.glucosense.dto.Enum_dto.ConsultationStatusDTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class ConsultationDTO {
    private Long id;
    private PatientDTO patient;
    private DoctorDTO doctor;
    private ChiefDoctorDTO chiefDoctor;
    private LocalDateTime consultationDate;
    private ConsultationStatusDTO status;
    private String notes;
}