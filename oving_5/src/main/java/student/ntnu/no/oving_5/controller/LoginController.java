package student.ntnu.no.oving_5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import student.ntnu.no.oving_5.model.login.LoginRequest;
import student.ntnu.no.oving_5.model.login.LoginResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import student.ntnu.no.oving_5.service.LoginService;

@RestController
@RequestMapping(value = "/login")
@EnableAutoConfiguration
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;

    private static final Logger LOGGER = LogManager.getLogger(LoginController.class);

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public LoginResponse doLogin(final @RequestBody LoginRequest loginRequest){
        //LOGGER.info("Logging in..." + loginRequest.getUsername());
        return loginService.doLogin(loginRequest);
    }

}
