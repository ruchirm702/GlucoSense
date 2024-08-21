package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(String message) {
        super(message);
    }
}