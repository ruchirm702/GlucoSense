package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class EmergencyContactNotFoundException extends RuntimeException {
    public EmergencyContactNotFoundException(String message) {
        super(message);
    }
}