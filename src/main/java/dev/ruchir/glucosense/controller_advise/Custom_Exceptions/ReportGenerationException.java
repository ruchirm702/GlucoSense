package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class ReportGenerationException extends RuntimeException {
    public ReportGenerationException(String message) {
        super(message);
    }
}