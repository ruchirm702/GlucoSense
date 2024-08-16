package dev.ruchir.glucosense.dto.Core_Dto;


import dev.ruchir.glucosense.dto.Enum_dto.DietTypeDTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class DietEntryDTO {
    private Long id;
    private PatientDTO patient;
    private String foodItem;
    private int carbohydrates;
    private DietTypeDTO type;
}