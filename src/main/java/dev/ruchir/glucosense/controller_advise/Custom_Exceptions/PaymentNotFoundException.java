package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class PaymentNotFoundException extends RuntimeException {
    public PaymentNotFoundException(String message) {
        super(message);
    }
}
