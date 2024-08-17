package dev.ruchir.glucosense.dto.Enum_dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserStatusDTO {
    private String statusName;

    // Assuming you need a way to get the name of the status
    public String name() {
        return statusName;
    }
}
