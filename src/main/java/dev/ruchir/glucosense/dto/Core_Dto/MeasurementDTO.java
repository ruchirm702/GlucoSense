package dev.ruchir.glucosense.dto.Core_Dto;

import dev.ruchir.glucosense.dto.Core_Dto.PatientDTO;
import dev.ruchir.glucosense.dto.Enum_dto.MeasurementTypeDTO;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementDTO {
    private Long id;
    private PatientDTO patient;
    private LocalDateTime measurementDate;
    private Double value;
    private MeasurementTypeDTO measurementType;
}
