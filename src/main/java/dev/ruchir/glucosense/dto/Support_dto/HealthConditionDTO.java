package dev.ruchir.glucosense.dto.Support_dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class HealthConditionDTO {
    private Long id;
    private String name;
    private String description;
}