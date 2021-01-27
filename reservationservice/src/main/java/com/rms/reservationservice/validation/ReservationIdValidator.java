package com.rms.reservationservice.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ReservationIdValidator implements ConstraintValidator<ValidateID, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //implement our own custom validation for the reservation Id.
        return false;
    }
}