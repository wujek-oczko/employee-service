package com.wujq.pay.employee.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements
        ConstraintValidator<AgeConstraint, Integer> {

    private static int ADULT_AGE = 18;
 
    @Override
    public void initialize(AgeConstraint contactNumber) {
    }
 
    @Override
    public boolean isValid(Integer contactField,
      ConstraintValidatorContext cxt) {
        return contactField != null && contactField >= ADULT_AGE;
    }
 
}
