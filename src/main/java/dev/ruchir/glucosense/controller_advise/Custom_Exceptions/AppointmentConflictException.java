package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class AppointmentConflictException extends RuntimeException {
    public AppointmentConflictException(String message) {
        super(message);
    }
}
