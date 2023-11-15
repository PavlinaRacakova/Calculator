package calculator.validation;

import calculator.form.MathOperation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static calculator.form.Operation.DIVISION;

/*
Validator class for @interface ItDoesNotDivideByZero
 */
public class ItDoesNotDivideByZeroValidator implements ConstraintValidator<ItDoesNotDivideByZero, MathOperation> {

    @Override
    public boolean isValid(MathOperation mathOperation, ConstraintValidatorContext context) {
        return !(mathOperation.getOperation() == DIVISION && mathOperation.getSecondNumberAsDouble() == 0);
    }
}