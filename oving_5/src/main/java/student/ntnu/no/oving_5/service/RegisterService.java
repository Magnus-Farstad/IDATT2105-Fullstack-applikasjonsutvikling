package student.ntnu.no.oving_5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.ntnu.no.oving_5.model.register.RegisterRequest;
import student.ntnu.no.oving_5.model.register.RegisterResponse;
import student.ntnu.no.oving_5.repository.JdbcRegisterRepository;

@Service
public class RegisterService {

    @Autowired
    private JdbcRegisterRepository jdbcRegisterRepository;

    public RegisterResponse registerUser(RegisterRequest registerRequest) {
        return jdbcRegisterRepository.registerUser(registerRequest);
    }
}
