package student.ntnu.no.oving_5.model.login;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponse {

    final private String loginStatus;
    private int user_id;
    private String username;
    private String name;

    public LoginResponse(@JsonProperty("loginStatus")  String loginStatus, int user_id, String username, String name) {
        this.loginStatus = loginStatus;
        this.user_id = user_id;
        this.username = username;
        this.name = name;
    }

    public LoginResponse(@JsonProperty("loginStatus") String loginStatus) {
        this.loginStatus = loginStatus;
    }

    @JsonProperty("loginStatus")
    public String getLoginStatus() {
        return loginStatus;
    }

    @JsonProperty("username")
    public String getUsername() {
        return this.username;
    }

    @JsonProperty("user_id")
    public int getUser_id() {
        return this.user_id;
    }

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }
}
