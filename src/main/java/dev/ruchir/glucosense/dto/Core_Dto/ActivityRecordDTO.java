package dev.ruchir.glucosense.dto.Core_Dto;



import java.time.LocalDateTime;

import dev.ruchir.glucosense.dto.Enum_dto.ActivityTypeDTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor


public class ActivityRecordDTO {
    private Long id;
    private PatientDTO patient;
    private ActivityTypeDTO activityType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int caloriesBurned;
}