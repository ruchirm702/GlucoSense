package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class PrescriptionNotFoundException extends RuntimeException {
    public PrescriptionNotFoundException(String message) {
        super(message);
    }
}