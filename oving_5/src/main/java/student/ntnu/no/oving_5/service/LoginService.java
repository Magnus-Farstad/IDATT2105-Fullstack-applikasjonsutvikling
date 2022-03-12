package student.ntnu.no.oving_5.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.ntnu.no.oving_5.model.login.LoginRequest;
import student.ntnu.no.oving_5.model.login.LoginResponse;
import student.ntnu.no.oving_5.repository.JdbcLoginRepository;

@Service
public class LoginService {

    @Autowired
    private JdbcLoginRepository jdbcLoginRepository;

    Logger logger = LoggerFactory.getLogger(LoginService.class);

    public LoginResponse doLogin(LoginRequest loginRequest) {
        logger.info("LoginService");
        return jdbcLoginRepository.doLogin(loginRequest);
    }
}
