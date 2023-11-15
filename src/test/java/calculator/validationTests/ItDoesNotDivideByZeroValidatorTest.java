package calculator.validationTests;

import calculator.form.MathOperation;
import calculator.form.Operation;
import calculator.validation.ItDoesNotDivideByZeroValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testing class for ItDoesNotDivideByZero annotation
 */

public class ItDoesNotDivideByZeroValidatorTest {

    private ItDoesNotDivideByZeroValidator validator;
    private MathOperation operation;

    @BeforeEach
    public void setup() {
        validator = new ItDoesNotDivideByZeroValidator();
        operation = new MathOperation();
    }

    @Test
    public void whenGivenSecondNumberIsNotZero_AndSelectedOperationIsDivision_thenValid() {
        //act
        operation.setOperation(Operation.DIVISION);
        operation.setSecondNumber("5");
        //assert
        assertTrue(validator.isValid(operation, null));
    }

    @Test
    public void whenGivenSecondNumberIsZero_AndSelectedOperationIsNotDivision_thenValid() {
        //act
        operation.setOperation(Operation.MULTIPLICATION);
        operation.setSecondNumber("0");
        //assert
        assertTrue(validator.isValid(operation, null));
    }

    @Test
    public void whenGivenSecondNumberIsZero_AndSelectedOperationIsDivision_thenInvalid() {
        //act
        operation.setOperation(Operation.DIVISION);
        operation.setSecondNumber("0");
        //assert
        assertFalse(validator.isValid(operation, null));
    }
}
