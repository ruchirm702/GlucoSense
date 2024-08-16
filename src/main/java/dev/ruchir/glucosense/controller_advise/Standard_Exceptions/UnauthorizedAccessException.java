package dev.ruchir.glucosense.controller_advise.Standard_Exceptions;

public class UnauthorizedAccessException extends RuntimeException {
    public UnauthorizedAccessException(String message) {
        super(message);
    }
}