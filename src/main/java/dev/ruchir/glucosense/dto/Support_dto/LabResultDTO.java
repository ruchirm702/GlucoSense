package dev.ruchir.glucosense.dto.Support_dto;


import java.time.LocalDateTime;

import dev.ruchir.glucosense.dto.Core_Dto.PatientDTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class LabResultDTO {
    private Long id;
    private PatientDTO patient;
    private String testName;
    private String result;
    private LocalDateTime date;
}