package calculator.controller;

import calculator.form.MathOperation;
import calculator.service.CalculatorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService service;

    @GetMapping("/")
    public String welcome() {
        return service.returnWelcomePage();
    }

    @GetMapping("/mainPage")
    public ModelAndView mainPage() {
        return service.returnMainPageAtStartingPoint();
    }

    @PostMapping("/mainPage")
    public ModelAndView calculate(@Valid @ModelAttribute("mathOperation") MathOperation mathOperation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("mainPage");
        }
        return service.returnMainPageIfUserSendsCalculableData(mathOperation);
    }
}