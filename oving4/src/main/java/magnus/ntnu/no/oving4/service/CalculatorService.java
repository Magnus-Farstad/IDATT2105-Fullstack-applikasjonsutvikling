package magnus.ntnu.no.oving4.service;

import magnus.ntnu.no.oving4.model.Calculation;
import magnus.ntnu.no.oving4.web.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    @Value("${name:World}")
    private String name;

    Logger logger = LoggerFactory.getLogger(CalculatorService.class);

    public Calculation add(Calculation calculation) {
        logger.info("add() was called");

        int first = calculation.getFirst();
        int second = calculation.getSecond();

        calculation.setAnswer(first + second);

        return calculation;
    }

    public Calculation subtract(Calculation calculation) {
        logger.info("subtract() was called");

        int first = calculation.getFirst();
        int second = calculation.getSecond();

        calculation.setAnswer(first - second);

        return calculation;
    }

    public Calculation multiply(Calculation calculation) {
        logger.info("multiply() was called");

        int first = calculation.getFirst();
        int second = calculation.getSecond();

        calculation.setAnswer(first * second);

        return calculation;
    }

    public Calculation divide(Calculation calculation) {
        logger.info("divide() was called");

        int first = calculation.getFirst();
        int second = calculation.getSecond();

        calculation.setAnswer(first / second);

        return calculation;
    }
}
