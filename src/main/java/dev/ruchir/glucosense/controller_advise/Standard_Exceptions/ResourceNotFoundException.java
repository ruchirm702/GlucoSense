package dev.ruchir.glucosense.controller_advise.Standard_Exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}