package magnus.ntnu.no.oving4.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    @Value("${name:World}")
    private String name;
}
