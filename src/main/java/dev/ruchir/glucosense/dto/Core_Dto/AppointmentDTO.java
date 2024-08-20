package dev.ruchir.glucosense.dto.Core_Dto;

import dev.ruchir.glucosense.model.Enum.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {
    private Long id;
    private Long patientId;
    private Long doctorId;
    private LocalDateTime appointmentDate;
    private String reason;
    private AppointmentStatus status;
}
