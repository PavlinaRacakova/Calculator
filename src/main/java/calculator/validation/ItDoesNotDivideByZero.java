package calculator.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
/*
Class validation annotation for MathOperation class to prevent division by zero during computations
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ItDoesNotDivideByZeroValidator.class)
public @interface ItDoesNotDivideByZero {

    String message() default "You can't divide by zero.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}