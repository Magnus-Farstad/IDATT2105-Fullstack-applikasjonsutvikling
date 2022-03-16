package student.ntnu.no.oving_5.model.login;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponse {

    final private String loginStatus;
    private int user_id;

    public LoginResponse(@JsonProperty("loginStatus")  String loginStatus, int user_id) {
        this.loginStatus = loginStatus;
        this.user_id = user_id;
    }

    public LoginResponse(@JsonProperty("loginStatus") String loginStatus) {
        this.loginStatus = loginStatus;
    }

    @JsonProperty("loginStatus")
    public String getLoginStatus() {
        return loginStatus;
    }

    @JsonProperty("user_id")
    public int getUser_id() {
        return this.user_id;
    }
}