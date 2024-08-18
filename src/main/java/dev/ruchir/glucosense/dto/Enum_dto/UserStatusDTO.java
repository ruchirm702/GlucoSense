package dev.ruchir.glucosense.dto.Enum_dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserStatusDTO {
    private String statusName;

    // Simulating an enum behavior with a static method
    public static UserStatusDTO valueOf(String statusName) {
        return new UserStatusDTO(statusName);
    }

    // Returns the name of the status
    public String name() {
        return statusName;
    }
}
