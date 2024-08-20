package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class InvalidAppointmentStatusException extends RuntimeException {
    public InvalidAppointmentStatusException(String message) {
        super(message);
    }
}
