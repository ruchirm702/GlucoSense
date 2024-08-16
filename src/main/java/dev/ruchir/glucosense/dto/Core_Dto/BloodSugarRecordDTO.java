package dev.ruchir.glucosense.dto.Core_Dto;

import java.time.LocalDateTime;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class BloodSugarRecordDTO {
    private Long id;
    private PatientDTO patient;
    private LocalDateTime timestamp;
    private double level;
}