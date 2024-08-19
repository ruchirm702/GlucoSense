package dev.ruchir.glucosense.dto.Enum_dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementTypeDTO {
    private String typeName;

    public static MeasurementTypeDTO valueOf(String typeName) {
        return new MeasurementTypeDTO(typeName);
    }

    public String name() {
        return typeName;
    }
}
