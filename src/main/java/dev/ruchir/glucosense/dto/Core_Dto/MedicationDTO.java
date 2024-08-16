package dev.ruchir.glucosense.dto.Core_Dto;


import dev.ruchir.glucosense.dto.Enum_dto.MedicationTypeDTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class MedicationDTO {
    private Long id;
    private String name;
    private MedicationTypeDTO type;
    private String dosage;
    private String frequency;
}