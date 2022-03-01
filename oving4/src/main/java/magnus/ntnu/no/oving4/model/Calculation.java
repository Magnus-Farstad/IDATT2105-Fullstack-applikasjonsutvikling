package magnus.ntnu.no.oving4.model;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
    private String first;
    private String operation;
    private String second;
    private List<String> calculations = new ArrayList<String>();

    public List<String> getCalculations() {
        return calculations;
    }

    public void setCalculations(List<String> calculations) {
        this.calculations = calculations;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }
}
