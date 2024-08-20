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

    /**
     * Fetch AppointmentStatus based on the provided status code.
     *
     * @param statusCode the status code of the appointment
     * @return the corresponding AppointmentStatus
     */
    public static AppointmentStatus fromStatusCode(int statusCode) {
        for (AppointmentStatus status : values()) {
            if (status.getStatusCode() == statusCode) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status code: " + statusCode);
    }

    /**
     * Fetch AppointmentStatus based on the provided description.
     *
     * @param description the description of the appointment status
     * @return the corresponding AppointmentStatus
     */
    public static AppointmentStatus fromDescription(String description) {
        for (AppointmentStatus status : values()) {
            if (status.getDescription().equalsIgnoreCase(description)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid description: " + description);
    }

    @Override
    public String toString() {
        return String.format("AppointmentStatus[description='%s', statusCode=%d]", description, statusCode);
    }
}
