package calculator.entity;

import calculator.validation.FirstGroupToBeValidated;
import calculator.validation.ItDoesNotDivideByZero;
import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

/*
Form class used for data storage
 */
@Getter
@Setter
@GroupSequence({FirstGroupToBeValidated.class, MathOperation.class})
@ItDoesNotDivideByZero
public class MathOperation {

    @Pattern(regexp = "^-?\\d{1,8}(?:\\.\\d{1,4})?$", message = "Not a valid number", groups = FirstGroupToBeValidated.class)
    private String firstNumber;

    @Pattern(regexp = "^-?\\d{1,8}(?:\\.\\d{1,4})?$", message = "Not a valid number", groups = FirstGroupToBeValidated.class)
    private String secondNumber;

    private String result;

    @NotNull(message = "Choose an operation", groups = FirstGroupToBeValidated.class)
    private Operation operation;

    public double getFirstNumberAsDouble() {
        return Double.parseDouble(firstNumber);
    }

    public double getSecondNumberAsDouble() {
        return Double.parseDouble(secondNumber);
    }
}