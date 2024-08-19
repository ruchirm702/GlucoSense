package dev.ruchir.glucosense.dto.Enum_dto;

import dev.ruchir.glucosense.model.Enum.Gender;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenderDTO {
    private Long id;
    private Gender gender;
    private String typeName;
}
