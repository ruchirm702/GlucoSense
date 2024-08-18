package dev.ruchir.glucosense.dto.Enum_dto;

import dev.ruchir.glucosense.model.Enum.MedicationType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicationTypeDTO {
    private String typeName;

    // Static method to create a MedicationTypeDTO from a MedicationType
    public static MedicationTypeDTO fromMedicationType(MedicationType medicationType) {
        return new MedicationTypeDTO(medicationType.name());
    }

    // Static method to convert a string to a MedicationTypeDTO
    public static MedicationTypeDTO valueOf(String name) {
        return new MedicationTypeDTO(name);
    }

    // Convert MedicationTypeDTO to MedicationType enum
    public MedicationType toMedicationType() {
        return MedicationType.valueOf(this.typeName);
    }
}
