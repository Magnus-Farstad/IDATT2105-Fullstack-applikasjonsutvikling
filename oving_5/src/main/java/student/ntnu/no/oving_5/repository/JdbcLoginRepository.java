package student.ntnu.no.oving_5.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import student.ntnu.no.oving_5.model.login.LoginRequest;
import student.ntnu.no.oving_5.model.login.LoginResponse;
import student.ntnu.no.oving_5.model.login.User;

@Repository
public class JdbcLoginRepository implements LoginRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    Logger logger = LoggerFactory.getLogger(JdbcLoginRepository.class);

    @Override
    public LoginResponse doLogin(LoginRequest loginRequest) {
        try {
            User user = jdbcTemplate.queryForObject("SELECT * FROM user WHERE username=? AND passw=?",
                    BeanPropertyRowMapper.newInstance(User.class), loginRequest.getUsername(), loginRequest.getPassword());

            logger.info(user.getUsername() + " is successfully logged in!");
            return new LoginResponse("Success", user.getUser_id(), user.getUsername());
        } catch (Exception exception) {
            logger.info(loginRequest.getUsername() + " failed to log in");
            return new LoginResponse("Fail");
        }
    }
}
