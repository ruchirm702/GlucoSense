package dev.ruchir.glucosense.controller_advise.Custom_Exceptions;

import dev.ruchir.glucosense.controller_advise.Standard_Exceptions.ResourceNotFoundException;

public class ActivityRecordNotFoundException extends ResourceNotFoundException {
    public ActivityRecordNotFoundException(String message) {
        super(message);
    }
}
