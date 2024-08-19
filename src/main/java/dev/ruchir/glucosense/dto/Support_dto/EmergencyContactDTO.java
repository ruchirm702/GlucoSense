package dev.ruchir.glucosense.dto.Support_dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyContactDTO {
    private Long id;
    private String name;
    private String relationship;
    private String phoneNumber;
}
