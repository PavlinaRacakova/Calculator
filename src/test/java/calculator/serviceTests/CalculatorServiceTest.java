package calculator.serviceTests;

import calculator.form.MathOperation;
import calculator.form.Operation;
import calculator.service.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing class for CalculatorService
 */
public class CalculatorServiceTest {

    private CalculatorService service;

    @BeforeEach
    public void setup() {
        service = new CalculatorService();
    }

    @Test
    public void whenWelcomePageIsRequested_thenReturnCorrectViewName() {
        //arrange
        String viewName;
        //act
        viewName = service.returnWelcomePage();
        //assert
        assertEquals("welcome", viewName);
    }

    @Test
    public void whenMainPageIsRequestedWithoutData_thenReturnModelAndViewWithEmptyMathOperation() {
        //arrange
        ModelAndView modelAndView;
        MathOperation mathOperation;
        //act
        modelAndView = service.returnMainPageAtStartingPoint();
        mathOperation = (MathOperation) modelAndView.getModel().get("mathOperation");
        //assert
        assertEquals("mainPage", modelAndView.getViewName());
        assertNull(mathOperation.getFirstNumber());
    }

    @Test
    public void whenMainPageIsRequestedWithValidUserData_thenReturnModelAndViewWithCalculatedMathOperation() {
        //arrange
        ModelAndView modelAndView;
        MathOperation mathOperation;
        //act
        mathOperation = new MathOperation();
        mathOperation.setFirstNumber("10");
        mathOperation.setSecondNumber("5");
        mathOperation.setOperation(Operation.ADDITION);
        modelAndView = service.returnMainPageIfUserSendsCalculableData(mathOperation);
        //assert
        assertEquals("mainPage", modelAndView.getViewName());
        assertEquals("15", mathOperation.getResult());
    }
}