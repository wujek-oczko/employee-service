package com.wujq.pay.employee.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AgeValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AgeConstraint {
    String message() default "Employee needs to be an adult";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
