package dev.ruchir.glucosense.dto.Core_Dto;

import dev.ruchir.glucosense.dto.Support_dto.UserDTO;
import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class DoctorDTO {
    private Long id;
    private Long roleId;
    private String username;
    private String specialty;
    private UserDTO user;
    private String name;


}
