package magnus.ntnu.no.oving4.web;

import magnus.ntnu.no.oving4.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private CalculatorService service;

    Logger logger = LoggerFactory.getLogger(RestController.class);
}
