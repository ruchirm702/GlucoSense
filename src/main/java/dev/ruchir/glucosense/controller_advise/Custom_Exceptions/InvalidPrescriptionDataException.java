package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class InvalidPrescriptionDataException extends RuntimeException {
    public InvalidPrescriptionDataException(String message) {
        super(message);
    }
}