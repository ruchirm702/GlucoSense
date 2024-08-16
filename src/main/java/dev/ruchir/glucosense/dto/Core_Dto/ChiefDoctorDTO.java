package dev.ruchir.glucosense.dto.Core_Dto;

import dev.ruchir.glucosense.dto.Support_dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class ChiefDoctorDTO {
    private Long id;
    private String name;
    private String department;
    private UserDTO user;
}