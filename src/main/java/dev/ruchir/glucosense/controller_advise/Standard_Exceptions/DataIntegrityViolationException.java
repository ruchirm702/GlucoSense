package dev.ruchir.glucosense.controller_advise.Standard_Exceptions;

public class DataIntegrityViolationException extends RuntimeException {
    public DataIntegrityViolationException(String message) {
        super(message);
    }
}
