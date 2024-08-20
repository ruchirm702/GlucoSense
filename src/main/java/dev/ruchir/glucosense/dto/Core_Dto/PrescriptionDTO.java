package dev.ruchir.glucosense.dto.Core_Dto;


import dev.ruchir.glucosense.dto.Enum_dto.PrescriptionStatusDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionDTO {

    private Long id;
    private Long patientId;
    private Long doctorId;
    private Long medicationId;
    private LocalDate prescriptionDate;
    private String instructions;
    private String duration;
    private PrescriptionStatusDTO status;
}
