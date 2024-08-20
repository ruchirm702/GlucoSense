package dev.ruchir.glucosense.model.Enum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AppointmentStatus {
    SCHEDULED("Scheduled", 1),
    COMPLETED("Completed", 2),
    CANCELLED("Cancelled", 3);

    private final String description;
    private final int statusCode;
}
