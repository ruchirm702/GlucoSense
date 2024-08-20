package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class NotificationAlreadyExistsException extends RuntimeException {
    public NotificationAlreadyExistsException(String message) {
        super(message);
    }
}