package magnus.ntnu.no.oving4.web;

import magnus.ntnu.no.oving4.model.Calculation;
import magnus.ntnu.no.oving4.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/calculator")
@EnableAutoConfiguration
@CrossOrigin
public class RestController {

    @Autowired
    private CalculatorService service;

    Logger logger = LoggerFactory.getLogger(RestController.class);

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
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

            default:
                logger.warn("From calculate(): Operation was not valid");
                calculation.setOperation("");
        }
        return calculation;
    }
}
