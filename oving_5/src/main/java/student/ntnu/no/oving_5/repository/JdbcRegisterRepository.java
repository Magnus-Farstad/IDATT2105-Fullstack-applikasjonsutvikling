package student.ntnu.no.oving_5.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import student.ntnu.no.oving_5.model.register.RegisterRequest;
import student.ntnu.no.oving_5.model.register.RegisterResponse;

@Repository
public class JdbcRegisterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public RegisterResponse registerUser(RegisterRequest registerRequest) {

        int status = jdbcTemplate.update("INSERT INTO user (user_id, name, username, passw, address, email, phone) VALUES (DEFAULT, ?, ?, ?, ?, ?, ?)",
                new Object[] {registerRequest.getName(), registerRequest.getUsername(), registerRequest.getPassword(), registerRequest.getAddress(), registerRequest.getEmail(), registerRequest.getPhone()});

        if (status > 0) {
            return new RegisterResponse("Register was Successful!", registerRequest.getName(), registerRequest.getAddress(),
                    registerRequest.getUsername(), registerRequest.getPassword(),
                    registerRequest.getEmail(), registerRequest.getPhone());
        } else {
            return new RegisterResponse("Register failed");
        }
    }
}
