package dev.ruchir.glucosense.dto.Core_Dto;



import java.time.LocalDateTime;

import dev.ruchir.glucosense.dto.Enum_dto.MeasurementTypeDTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementDTO {
    private Long id;
    private PatientDTO patient;
    private MeasurementTypeDTO type;
    private double value;
    private LocalDateTime timestamp;
}