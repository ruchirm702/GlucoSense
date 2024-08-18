package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class DoctorNotFoundException extends RuntimeException {
    public DoctorNotFoundException(String message) {
        super(message);
    }
}