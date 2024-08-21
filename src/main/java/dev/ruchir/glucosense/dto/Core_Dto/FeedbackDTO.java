package dev.ruchir.glucosense.dto.Core_Dto;

import dev.ruchir.glucosense.dto.Enum_dto.FeedbackTargetEntityTypeDTO;
import dev.ruchir.glucosense.dto.Enum_dto.FeedbackRatingDTO;
import lombok.*;

import java.time.LocalDate;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDTO {
    private Long id;
    private Long patientId;
    private FeedbackTargetEntityTypeDTO targetEntityType;
    private Long targetEntityId;
    private String comments;
    private FeedbackRatingDTO rating;
    private LocalDate feedbackDate;
}
