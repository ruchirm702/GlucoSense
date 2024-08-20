package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class NotificationNotFoundException extends RuntimeException {
    public NotificationNotFoundException(String message) {
        super(message);
    }
}
