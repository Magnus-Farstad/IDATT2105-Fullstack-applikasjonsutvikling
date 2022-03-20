package student.ntnu.no.oving_5.service;

import org.springframework.beans.factory.annotation.Autowired;
import student.ntnu.no.oving_5.model.calculation.Calculation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import student.ntnu.no.oving_5.repository.JdbcCalculationRepository;

import java.util.List;

@Service
public class CalculatorService {

    @Autowired
    JdbcCalculationRepository jdbcCalculationRepository;

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

    public int saveCalculation(int id, Calculation calculation) {
        logger.info("CalculatorService");
        String calc = calculation.getFirst() + calculation.getOperation() + calculation.getSecond() + "=" + calculation.getAnswer();
        return jdbcCalculationRepository.saveCalculation(id, calc);
    }

    public List<Calculation> getAllCalculations(int id) {
        return jdbcCalculationRepository.getAllCalculations(id);
    }
}
