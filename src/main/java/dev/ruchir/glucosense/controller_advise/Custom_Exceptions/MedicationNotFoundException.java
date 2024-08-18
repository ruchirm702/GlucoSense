package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class MedicationNotFoundException extends RuntimeException {
    public MedicationNotFoundException(String message) {
        super(message);
    }
}