package dev.ruchir.glucosense.dto.Core_Dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InsuranceDTO {

    private Long id;
    private Long patientId;
    private String providerName;
    private String policyNumber;
    private String coverageDetails;
    private LocalDate expiryDate;
}
