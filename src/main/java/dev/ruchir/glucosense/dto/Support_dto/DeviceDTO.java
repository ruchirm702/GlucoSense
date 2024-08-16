package dev.ruchir.glucosense.dto.Support_dto;



import dev.ruchir.glucosense.dto.Core_Dto.PatientDTO;
import dev.ruchir.glucosense.dto.Enum_dto.DeviceTypeDTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class DeviceDTO {
    private Long id;
    private String name;
    private DeviceTypeDTO type;
    private String serialNumber;
    private PatientDTO patient;
}