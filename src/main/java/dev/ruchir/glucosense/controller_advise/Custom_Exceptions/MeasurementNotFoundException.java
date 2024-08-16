package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

import dev.ruchir.glucosense.controller_advise.Standard_Exceptions.ResourceNotFoundException;

public class MeasurementNotFoundException extends ResourceNotFoundException {
    public MeasurementNotFoundException(String message) {
        super(message);
    }
}
