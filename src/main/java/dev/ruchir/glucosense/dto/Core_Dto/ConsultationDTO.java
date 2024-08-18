package dev.ruchir.glucosense.dto.Core_Dto;

import java.time.LocalDateTime;
import dev.ruchir.glucosense.model.Enum.ConsultationStatus;
import lombok.*;

@Builder
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
    private ConsultationStatus status;
    private String notes;
    private LocalDateTime dateTime;


}