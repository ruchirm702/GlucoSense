package dev.ruchir.glucosense.dto.Support_dto;



import dev.ruchir.glucosense.dto.Enum_dto.UserStatusDTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private UserStatusDTO status;
    private RoleDTO role;
}