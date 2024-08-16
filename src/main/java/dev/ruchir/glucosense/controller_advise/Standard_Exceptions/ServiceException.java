package dev.ruchir.glucosense.controller_advise.Standard_Exceptions;

public class ServiceException extends RuntimeException {
    public ServiceException(String message) {
        super(message);
    }
}