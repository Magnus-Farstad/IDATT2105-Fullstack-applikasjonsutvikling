package student.ntnu.no.oving_5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import student.ntnu.no.oving_5.model.register.RegisterRequest;
import student.ntnu.no.oving_5.model.register.RegisterResponse;
import student.ntnu.no.oving_5.service.RegisterService;

@RestController
@RequestMapping(value = "/register")
@EnableAutoConfiguration
@CrossOrigin
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public RegisterResponse doRegistration(@RequestBody RegisterRequest registerRequest) {
        return registerService.registerUser(registerRequest);
    }
}
