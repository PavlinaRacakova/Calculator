package calculator.validationTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItDoesNotDivideByZeroValidatorTest {

    @BeforeEach
    public void setup() {

    }

    @Test
    public void givenSecondNumberIsNot0_WhenSelectedOperationIsDivision_thenOk() {

    }
}
