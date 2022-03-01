package magnus.ntnu.no.oving4.service;

import magnus.ntnu.no.oving4.model.Calculation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    @Value("${name:World}")
    private String name;

    public Calculation add(Calculation calculation) {
        int first = calculation.getFirst();
        int second = calculation.getSecond();

        calculation.setAnswer(first + second);

        return calculation;
    }

    public Calculation subtract(Calculation calculation) {
        int first = calculation.getFirst();
        int second = calculation.getSecond();

        calculation.setAnswer(first - second);

        return calculation;
    }

    public Calculation multiply(Calculation calculation) {
        int first = calculation.getFirst();
        int second = calculation.getSecond();

        calculation.setAnswer(first * second);

        return calculation;
    }

    public Calculation divide(Calculation calculation) {
        int first = calculation.getFirst();
        int second = calculation.getSecond();

        calculation.setAnswer(first / second);

        return calculation;
    }
}
