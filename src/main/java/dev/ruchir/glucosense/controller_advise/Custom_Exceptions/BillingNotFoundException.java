package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class BillingNotFoundException extends RuntimeException {
    public BillingNotFoundException(String message) {
        super(message);
    }
}
