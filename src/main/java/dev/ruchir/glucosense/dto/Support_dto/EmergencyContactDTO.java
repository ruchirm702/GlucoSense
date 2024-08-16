package dev.ruchir.glucosense.dto.Support_dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class EmergencyContactDTO {
    private Long id;
    private String name;
    private String relationship;
    private String phone;
    private String email;
}