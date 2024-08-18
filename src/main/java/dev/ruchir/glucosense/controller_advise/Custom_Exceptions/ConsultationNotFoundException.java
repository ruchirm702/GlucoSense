package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class ConsultationNotFoundException extends RuntimeException {
    public ConsultationNotFoundException(String message) {
        super(message);
    }
}