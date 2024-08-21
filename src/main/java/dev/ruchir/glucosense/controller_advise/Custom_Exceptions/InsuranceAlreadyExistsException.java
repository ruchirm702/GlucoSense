package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class InsuranceAlreadyExistsException extends RuntimeException {
    public InsuranceAlreadyExistsException(String message) {
        super(message);
    }
}