package student.ntnu.no.oving_5.service;

import student.ntnu.no.oving_5.model.Calculation;
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

        double first = calculation.getFirst();
        double second = calculation.getSecond();

        calculation.setAnswer(first + second);

        return calculation;
    }

    public Calculation subtract(Calculation calculation) {
        logger.info("subtract() was called");

        double first = calculation.getFirst();
        double second = calculation.getSecond();

        calculation.setAnswer(first - second);

        return calculation;
    }

    public Calculation multiply(Calculation calculation) {
        logger.info("multiply() was called");

        double first = calculation.getFirst();
        double second = calculation.getSecond();

        calculation.setAnswer(first * second);

        return calculation;
    }

    public Calculation divide(Calculation calculation) {
        logger.info("divide() was called");

        double first = calculation.getFirst();
        double second = calculation.getSecond();

        calculation.setAnswer(first / second);

        return calculation;
    }
}
