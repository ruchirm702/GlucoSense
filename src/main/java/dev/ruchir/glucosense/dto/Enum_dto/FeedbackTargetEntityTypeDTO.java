package dev.ruchir.glucosense.dto.Enum_dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackTargetEntityTypeDTO {
    private String entityType;  // e.g., "Doctor", "Appointment", "Medication"
}
