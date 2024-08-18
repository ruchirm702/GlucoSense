package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class InvalidConsultationDataException extends RuntimeException {
    public InvalidConsultationDataException(String message) {
        super(message);
    }
}