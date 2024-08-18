package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;


public class MeasurementNotFoundException extends RuntimeException {
    public MeasurementNotFoundException(String message) {
        super(message);
    }
}
