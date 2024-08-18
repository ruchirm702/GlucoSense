package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

public class DeviceNotFoundException extends RuntimeException {
    public DeviceNotFoundException(String message) {
        super(message);
    }
}