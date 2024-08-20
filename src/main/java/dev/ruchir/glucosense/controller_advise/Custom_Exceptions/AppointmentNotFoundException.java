package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class AppointmentNotFoundException extends RuntimeException {
    public AppointmentNotFoundException(String message) {
        super(message);
    }
}
