package student.ntnu.no.oving_5.model;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
    private double first;
    private String operation;
    private double second;
    private double answer;
    private List<String> calculations = new ArrayList<String>();

    public Calculation() {

    }

    public Calculation(double first, String operation, double second, double answer) {
        this.first = first;
        this.operation = operation;
        this.second = second;
        this.answer = answer;
    }

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }

    public List<String> getCalculations() {
        return calculations;
    }

    public void setCalculations(List<String> calculations) {
        this.calculations = calculations;
    }

    public double getFirst() {
        return first;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getSecond() {
        return second;
    }

    public void setSecond(double second) {
        this.second = second;
    }
}
