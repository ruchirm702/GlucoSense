package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(String message) {
        super(message);
    }
}