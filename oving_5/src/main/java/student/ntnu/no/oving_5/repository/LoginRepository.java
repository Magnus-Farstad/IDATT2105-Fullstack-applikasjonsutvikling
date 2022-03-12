package student.ntnu.no.oving_5.repository;

import student.ntnu.no.oving_5.model.login.LoginRequest;
import student.ntnu.no.oving_5.model.login.LoginResponse;

public interface LoginRepository {

    public LoginResponse doLogin(LoginRequest loginRequest);
}
