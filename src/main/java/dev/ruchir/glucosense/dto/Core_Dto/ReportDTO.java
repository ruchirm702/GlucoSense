package dev.ruchir.glucosense.dto.Core_Dto;


import dev.ruchir.glucosense.dto.Enum_dto.ReportStatusDTO;
import dev.ruchir.glucosense.dto.Enum_dto.ReportTypeDTO;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReportDTO {
    private Long id;
    private ReportTypeDTO reportType;
    private ReportStatusDTO reportStatus;
    private Long patientId;
    private String reportContent;
    private LocalDateTime generatedDate;
}
