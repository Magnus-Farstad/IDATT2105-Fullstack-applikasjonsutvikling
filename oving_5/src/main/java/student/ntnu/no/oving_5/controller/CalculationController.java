package student.ntnu.no.oving_5.controller;

import org.springframework.http.ResponseEntity;
import student.ntnu.no.oving_5.model.calculation.Calculation;
import student.ntnu.no.oving_5.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/calculator")
@EnableAutoConfiguration
@CrossOrigin
public class CalculationController {

    @Autowired
    private CalculatorService service;

    Logger logger = LoggerFactory.getLogger(CalculationController.class);

    @PostMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Calculation calculate(@RequestBody Calculation calculation, @PathVariable("id") int id) {
        logger.trace("PostMapping('/calculator') calculate() was called");
        String calc = calculation.getFirst() + calculation.getOperation() + calculation.getSecond() + "=" + calculation.getAnswer();
        logger.info(calc);
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
        saveCalculation(calculation, id);
        return calculation;
    }

    private ResponseEntity<String> saveCalculation(Calculation calculation, int id) {
        logger.trace("CalculationController");
        try {
            service.saveCalculation(id, new Calculation(calculation.getFirst(), calculation.getOperation(), calculation.getSecond(), calculation.getAnswer()));
            return  new ResponseEntity<>("Calculation was successfully saved", HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/calculations/{id}")
    public ResponseEntity<List<Calculation>> getAllCalculations(@PathVariable("id") int id) {
        System.out.println("getAllCalculations()");
        try {
            List<Calculation> calculations = new ArrayList<Calculation>();
            service.getAllCalculations(id).forEach(calculations::add);

            if (calculations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(calculations, HttpStatus.OK);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public int deleteCalculation(@PathVariable("id") int id) {
        logger.info("Deleting calculation " + id);
        return service.deleteCalculation(id);
    }
}
