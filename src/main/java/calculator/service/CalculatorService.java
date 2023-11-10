package calculator.service;

import calculator.entity.MathOperation;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.text.DecimalFormat;

@Service
public class CalculatorService {

    public String returnWelcomePage() {
        return "welcome";
    }

    public ModelAndView returnMainPageAtStartingPoint() {
        ModelAndView modelAndView = new ModelAndView("mainPage");
        modelAndView.addObject("mathOperation", new MathOperation());
        return modelAndView;
    }

    public ModelAndView returnMainPageIfUserSendsCalculableData(MathOperation mathOperation) {
        calculateResult(mathOperation);
        return new ModelAndView("mainPage");
    }

    private void calculateResult(MathOperation mathOperation) {
        switch (mathOperation.getOperation()) {
            case ADDITION ->
                    mathOperation.setResult(formatDoubleToDesiredAppearance(mathOperation.getFirstNumberAsDouble() + mathOperation.getSecondNumberAsDouble()));
            case SUBTRACTION ->
                    mathOperation.setResult(formatDoubleToDesiredAppearance(mathOperation.getFirstNumberAsDouble() - mathOperation.getSecondNumberAsDouble()));
            case MULTIPLICATION ->
                    mathOperation.setResult(formatDoubleToDesiredAppearance(mathOperation.getFirstNumberAsDouble() * mathOperation.getSecondNumberAsDouble()));
            case DIVISION -> {
                if (mathOperation.getSecondNumberAsDouble() != 0) {
                    mathOperation.setResult(formatDoubleToDesiredAppearance(mathOperation.getFirstNumberAsDouble() / mathOperation.getSecondNumberAsDouble()));
                } else {
                    mathOperation.setResult("0");
                }
            }
        }
    }

    private String formatDoubleToDesiredAppearance(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        return decimalFormat.format(value);
    }
}