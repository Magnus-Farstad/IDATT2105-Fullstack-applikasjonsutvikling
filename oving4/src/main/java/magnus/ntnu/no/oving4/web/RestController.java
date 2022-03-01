package magnus.ntnu.no.oving4.web;

import magnus.ntnu.no.oving4.model.Calculation;
import magnus.ntnu.no.oving4.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private CalculatorService service;

    Logger logger = LoggerFactory.getLogger(RestController.class);

    @PostMapping("/calculator")
    public Calculation calculate(@RequestBody Calculation calculation) {
        logger.trace("PostMapping('/calculator') calculate() was called");
        switch (calculation.getOperation()) {
            case "+":
                service.add(calculation);
                break;

            case "-":
                service.subtract(calculation);
                break;

            case "*":
                service.multiply(calculation);
                break;

            case "/":
                service.divide(calculation);
                break;
        }
        return calculation;
    }
}
