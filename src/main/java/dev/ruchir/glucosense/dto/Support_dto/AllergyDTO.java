package dev.ruchir.glucosense.dto.Support_dto;




import dev.ruchir.glucosense.dto.Enum_dto.AllergyTypeDTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class AllergyDTO {
    private Long id;
    private String name;
    private AllergyTypeDTO type;
    private String description;
}