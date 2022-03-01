package magnus.ntnu.no.oving4.model;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
    private int first;
    private String operation;
    private int second;
    private int answer;
    private List<String> calculations = new ArrayList<String>();

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public List<String> getCalculations() {
        return calculations;
    }

    public void setCalculations(List<String> calculations) {
        this.calculations = calculations;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}
