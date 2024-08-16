package dev.ruchir.glucosense.controller_advise.Standard_Exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}